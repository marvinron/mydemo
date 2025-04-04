package com.maviron.spring.springdemo.actor;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.lang.reflect.Constructor;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ActorSystem.java
 * @Description TODO
 * @createTime 2023年07月13日 14:32:00
 */
public class ActorSystem {

    private static long startTime;

    private static Map<String, InetSocketAddress> clusterConfig;
    /**
     * 当前绑定到的节点
     */
    private static Node currNode;
    /**
     * 维护线程与Actor的对应关系
     */
    private final static Map<String, Actor> actors = new HashMap<>();
    /**
     * 维护线程和actor的对应关系
     */
    private final static ThreadLocal<Actor> currThreadActor = new ThreadLocal<>();

    /**
     * 客户端Netty bootstrap
     */
    private static Bootstrap clientBootstrap;

    /**
     * 维护节点与通道的对应关系
     */
    private final static Map<String, Channel> channels = new ConcurrentHashMap<>();

    /**
     * 获取程序启动到当前时间的时间戳
     */
    public static long currTimestamp() {
        return System.currentTimeMillis() - startTime;
    }

    public static void send(Message msg) {
        String destNodeName = msg.getDestNode();
        String destActorName = msg.getDestActor();
        if (destNodeName.equals(currNode.getName())) {
            Actor destActor = actors.get(destActorName);
            destActor.act(msg);
        } else {
            sendToAnotherNode(msg);
        }
    }

    private static void sendToAnotherNode(Message msg) {
        try {
            String destNodeName = msg.getDestNode();
            //如果没有连接先建立连接
            Channel channel = getChannel(destNodeName);
            if (!isChannelValid(channel)) {
                InetSocketAddress address = clusterConfig.get(destNodeName);
                clientBootstrap.connect(address).addListener(new ChannelFutureListener(){

                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        setChannel(destNodeName,future.channel());
                        future.channel().writeAndFlush(msg);
                    }
                });
            } else {
                channel.writeAndFlush(msg);
            }
        } catch (Exception e) {

        }
    }
    public static void send(String destNodeName, String destActorName, String command, Object... params) {
        Actor srcActor = currThreadActor.get();
        String srcActorName = srcActor == null ? null : srcActor.getName();
        String srcNodeName = srcActor == null ? null : srcActor.getNode().getName();
        Message msg = new Message(command, srcNodeName, srcActorName, destNodeName, destActorName, params);
        send(msg);
    }
    public static void setChannel(String destNodeName, Channel channel) {
        channels.put(destNodeName, channel);
    }

    public static boolean isChannelValid(Channel channel) {
        return channel != null && channel.isActive() && channel.isWritable();
    }

    public static Channel getChannel(String destNodeName) {
        return channels.get(destNodeName);
    }

    public static void setThreadLocalActor(Actor actor) {
        currThreadActor.set(actor);
    }

    private static void startNettyBootstrap() {
        try {
            // 先启动服务端bootstrap
            EventLoopGroup bossGroup = new NioEventLoopGroup(1);
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)))
                                    .addLast(new ObjectEncoder())
                                    .addLast(new ServerHandler());

                        }
                    });
            InetSocketAddress address = clusterConfig.get(currNode.getName());
            b.bind(address).sync();

            // 再启动客户端bootstrap
            EventLoopGroup group = new NioEventLoopGroup();
            clientBootstrap = new Bootstrap();
            clientBootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)))
                                    .addLast(new ObjectEncoder())
                                    .addLast(new ClientHandler());
                        }
                    });
        } catch (Exception e) {
        }

    }

    public static void start() {
        // 启动定时器
        Timer.start();
        // 启动Netty bootstrap
        startNettyBootstrap();
    }
    /**
     * Actor发送给自己
     */
    public static void sendSelf(String command, Object... params) {
        Actor selfActor = currThreadActor.get();
        if (selfActor == null) {
            throw new RuntimeException("not in an actor, send fail");
        }
        send(selfActor.getNode().getName(), selfActor.getName(), command, params);
    }
    /**
     * 维护节点与通道的对应关系
     */
    public static void sleep(long millis, String command, Object... params) {
        String destActorName = currThreadActor.get().getName();
        Timer.addTimeTask(new TimerTask(System.currentTimeMillis() + millis, () -> {
            ActorSystem.send(currNode.getName(), destActorName, command, params);
        }));
    }

    public static void conf(Map<String, InetSocketAddress> config) {
        clusterConfig = config;
    }

    public static void bindNode(Class<? extends Node> nodeClass, String nodeName) {
        InetSocketAddress address = clusterConfig.get(nodeName);
        try {
            Constructor<? extends Node> constructor = nodeClass.getDeclaredConstructor();
            Node node = constructor.newInstance();
            node.setName(nodeName);
            currNode = node;
        } catch (Exception e) {
            throw new RuntimeException("create node fail", e);
        }

    }
    /**
     * 启动新的Actor
     */
    public static void newActor(Class<? extends Actor> actorClass, String name) {
        try {
            Constructor<? extends Actor> constructor =  actorClass.getDeclaredConstructor();
            Actor actor = constructor.newInstance();
            actor.setName(name);
            actor.setNode(currNode);
            actor.start();
            actors.put(name, actor);
        } catch (Exception e) {
            throw new RuntimeException("create actor fail", e);
        }
    }

}
