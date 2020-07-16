package com.anhen.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @classname: Test589
 * @description:
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/solution/marveljian-dan-de-xue-xi-bi-ji-590-by-tyanyonecanc/
 *
 * @author: wuxiaojian
 * @create: 2020-07-16 15:30
 */

public class Test589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    //递归
    public void preOrder(Node root, List<Integer> list) {
        if (root != null){
            list.add(root.val);
            if (root.children != null){
                for (Node node : root.children){
                    preOrder(node, list);
                }
            }
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            //头结点加入结果集
            res.add(cur.val);
            //将该节点的子节点从右往左压入栈
            List<Node> nodeList = cur.children;
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                stack.push(nodeList.get(i));
            }
        }
        return res;
    }
}
