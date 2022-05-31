package com.maviron.spring.springdemo.demo.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description
 * @createTime 2022年03月29日 11:59:00
 */
public class Solution {
    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            //只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
            return root;
        }
        //根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //p和q都没找到，那就没有
        if(left == null && right == null) {
            return null;
        }
        //左子树没有p也没有q，就返回右子树的结果
        if (left == null) {
            return right;
        }
        //右子树没有p也没有q就返回左子树的结果
        if (right == null) {
            return left;
        }
        //左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        return root;
    }

    public static void main(String[] args) throws Exception {
        String string ="http://baidu.com?a=123&b=13245";
        URL uri = new URL(string);
        String host = uri.getHost();
        System.out.println(host);
        boolean b = StringUtils.containsAny("5", "3,4");
        System.out.println(b);
        String s = null;
        String s1 = StringUtils.defaultIfEmpty(s, "13123");
        System.out.println(s1);

    }

    private static void getNPE(String x){
        System.out.println("当前字母为："+x.toString());
    }
}
