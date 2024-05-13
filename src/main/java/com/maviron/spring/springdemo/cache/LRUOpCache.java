package com.maviron.spring.springdemo.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 优化后的可高并发以及线程安全的场景（可用于生产）
 *
 * @param <K>
 * @param <V>
 */
class LRUOpCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> cache;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUOpCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>();
        this.head = new Node<>();
        this.tail = new Node<>();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            node = new Node<>(key, value);
            cache.put(key, node);
            addToHead(node);
            if (cache.size() > capacity) {
                Node<K, V> removed = removeTail();
                cache.remove(removed.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private Node<K, V> removeTail() {
        Node<K, V> removed = tail.prev;
        removeNode(removed);
        return removed;
    }


    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        // LRUOpCache<Integer, String> cache = new LRUOpCache<>(20000);
        // for (int i = 0; i < 2000; i++) {
        //     cache.put(i, "One");
        // }
        // String s = cache.get(5);
        // System.out.println(s);
        // System.out.println(cache.cache.size());

        // System.out.println(cache.get(1)); // Output: One
        // System.out.println(cache.get(2)); // Output: Two


        // System.out.println(cache.get(3)); // Output: null, as it was the least recently used

        LRUOpCache<Integer, String> cache = new LRUOpCache<>(2);
        cache.put(1, "One");
        cache.put(2, "One");
        cache.get(1);
        cache.put(3,"one");
        System.out.println(cache.toString());
    }
}

