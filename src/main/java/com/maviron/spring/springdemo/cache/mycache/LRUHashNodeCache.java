package com.maviron.spring.springdemo.cache.mycache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName LRUHashNodeCache.java
 * @Description 使用Hash表和双向链表实现LRU Cache
 * @createTime 2024年03月08日 15:14:00
 */
public class LRUHashNodeCache {
    /**
     * 双向链表的长度
     */
    private int size;
    /**
     * 最大容量
     */
    private int capacity;
    /**
     * Hash表 存储数据
     */
    private Map<Integer, DoubleLinkedNode> cache;
    /**
     * 双向链表的头节点  不存储任何值 标识作用
     */
    private DoubleLinkedNode head;
    /**
     * 双向链表的尾节点  不存储任何值 标识作用
     */
    private DoubleLinkedNode tail;

    /**
     * 构造方法
     *
     * @param capacity
     */
    public LRUHashNodeCache(int capacity) {
        this.size = size;
        this.capacity = capacity;
        this.cache = new HashMap<>();//线程安全可以使用ConcurrentHashMap以及putIfAbsent
        this.head = new DoubleLinkedNode();
        this.tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 获取元素
     *
     * @param key
     * @return
     */
    public int get(int key) {
        DoubleLinkedNode node = this.cache.get(key);
        //如果获取的节点不存在
        if (Objects.isNull(node)) {
            return -1;
        }
        //移动到双向链表到头部
        moveToHead(node);
        //返回值
        return node.value;
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DoubleLinkedNode(key, value);
            //添加到Hash表中
            cache.put(key, node);
            //双向链表的长度+1
            size++;
            addToHead(node);
            //如果长度大于容量
            if (size > capacity) {
                //双向链表中删除最后一个元素
                DoubleLinkedNode tail = removeTail();
                //同时从Hash表中删除元素

            }
        }
    }

    /**
     * 自己构造一个双向链表的节点
     */
    class DoubleLinkedNode {
        /**
         * 键
         */
        int key;
        /**
         * 值
         */
        int value;
        /**
         * 双向链表的前驱节点
         */
        DoubleLinkedNode prev;
        /**
         * 双向链表的后继节点
         */
        DoubleLinkedNode next;

        /**
         * 构造方法
         */
        public DoubleLinkedNode() {
        }

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }


    }

    /**
     * 添加一个节点到双向链表的头部
     *
     * @param node
     */
    private void addToHead(DoubleLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    /**
     * 双向链表中删除一个节点
     *
     * @param node
     */
    private void removeNode(DoubleLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
    }

    /**
     * 将双向链表中的一个节点移动到头部
     *
     * @param node
     */
    public void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 移除双向链表中的最后一个节点
     *
     * @return
     */
    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

}
