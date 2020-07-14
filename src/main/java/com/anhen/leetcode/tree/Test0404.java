package com.anhen.leetcode.tree;

import com.anhen.leetcode.tree.model.TreeNode;

/**
 * @classname: Test0404
 * @description:
 * 面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 * @author: wuxiaojian
 * @create: 2020-07-14 14:35
 */
public class Test0404 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(getDepth(root.left,0) - getDepth(root.right, 0)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 获取某个节点开始的最大深度
     * @param treeNode:
     * @param depth:
     **/
    public int getDepth(TreeNode treeNode, int depth){
        if (treeNode == null){
            return depth;
        }
        int leftDepth = getDepth(treeNode.left, depth + 1);
        int rightDepth = getDepth(treeNode.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }
}
