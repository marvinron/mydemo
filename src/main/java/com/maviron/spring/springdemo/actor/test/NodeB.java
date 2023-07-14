package com.maviron.spring.springdemo.actor.test;


import com.maviron.spring.springdemo.actor.ActorSystem;
import com.maviron.spring.springdemo.actor.Node;

/**
 * 模拟节点B
 */
public class NodeB extends Node {

	public static void main(String args[]) {
		ActorSystem.conf(Cluster.getConfig());
		ActorSystem.bindNode(NodeB.class, "nodeB");
		ActorSystem.start();
		ActorSystem.newActor(ActorPong.class, "pong");
	}
}
