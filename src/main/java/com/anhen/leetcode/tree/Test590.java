package com.anhen.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @classname: Test590
 * @description:
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * @author: wuxiaojian
 * @create: 2020-07-16 14:36
 */
public class Test590 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    };

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    //递归
    public void postOrder(Node root, List<Integer> list) {
        if (root != null){
            if (root.children != null){
                for (Node node : root.children){
                    postOrder(node, list);
                }
            }
            list.add(root.val);
        }
    }

    public List<Integer> postorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }

}
