package com.anhen.leetcode.tree;

import com.anhen.leetcode.tree.model.TreeNode;

/**
 * @classname: Test104
 * @description:
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * @author: wuxiaojian
 * @create: 2020-07-22 09:38
 */
public class Test104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return getDepth(root, 0);
    }

    private int getDepth(TreeNode treeNode, int depth){
        if (treeNode == null){
            return depth;
        }
        int leftDepth = getDepth(treeNode.left, depth + 1);
        int rightDepth = getDepth(treeNode.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    public int getDepth2(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int leftDepth = getDepth2(treeNode.left);
            int rightDepth = getDepth2(treeNode.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
