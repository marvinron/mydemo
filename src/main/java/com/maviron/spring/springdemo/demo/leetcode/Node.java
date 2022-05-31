package com.maviron.spring.springdemo.demo.leetcode;

import java.util.Objects;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Node.java
 * @Description 链表节点
 * @createTime 2022年04月29日 09:53:00
 */
public class Node {
    public int value;
    public Node next;
    public Node(int data){
        this.value = data;
    }

    public static void main(String[] args) {
        Integer status = 0;
        System.out.println(Objects.isNull(status));
        System.out.println(Objects.equals(status,1));
    }
}
