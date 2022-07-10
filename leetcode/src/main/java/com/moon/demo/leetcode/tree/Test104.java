package com.moon.demo.leetcode.tree;

import com.moon.demo.leetcode.tree.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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

    //递归
    private int getDepth(TreeNode treeNode, int depth){
        if (treeNode == null){
            return depth;
        }
        int leftDepth = getDepth(treeNode.left, depth + 1);
        int rightDepth = getDepth(treeNode.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    //递归
    public int getDepth2(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int leftDepth = getDepth2(treeNode.left);
            int rightDepth = getDepth2(treeNode.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    // 层次遍历获取深度
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //层序遍历辅助队列
        Queue<TreeNode> helper = new LinkedList<>();
        helper.add(root);
        //记录二叉树层次
        int level = 0;
        while(!helper.isEmpty()){
            //当前层中的结点数
            int levelLength = helper.size();
            for(int i = 0; i<levelLength; i++){
                TreeNode temp = helper.poll();
                if(temp.left != null) {
                    helper.add(temp.left);
                }
                if(temp.right != null) {
                    helper.add(temp.right);
                }
            }
            level++;
        }
        return level;
    }
}
