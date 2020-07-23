package com.anhen.leetcode.tree;

import com.anhen.leetcode.tree.model.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @classname: Test404
 * @description:
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @author: wuxiaojian
 * @create: 2020-07-22 19:04
 */
public class Test404 {

    //迭代
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null){
            return sum;
        }
        Queue<Pair<TreeNode, Boolean>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, false));
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Pair<TreeNode, Boolean> treeNode = queue.poll();
                if (treeNode.getKey().left != null){
                    queue.add(new Pair<>(treeNode.getKey().left, true));
                }
                if (treeNode.getKey().right != null){
                    queue.add(new Pair<>(treeNode.getKey().right, false));
                }
                if (treeNode.getKey().left == null && treeNode.getKey().right == null && treeNode.getValue()){
                    sum += treeNode.getKey().val;
                }
            }
        }
        return sum;
    }

    //递归
    public int sumOfLeftLeaves2(TreeNode root) {
        sumOfLeftLeavesRecursion(root, false);
        return sum;
    }

    public int sum = 0;
    public void sumOfLeftLeavesRecursion(TreeNode root, boolean left) {
        if (root != null){
            if (root.left == null && root.right == null && left){
                sum += root.val;
            }
            sumOfLeftLeavesRecursion(root.left, true);
            sumOfLeftLeavesRecursion(root.right, false);
        }
    }

    //递归
    public int sumOfLeftLeaves(TreeNode root, boolean flag){
        if(root == null){
            return 0;
        }
        if(flag && root.left == null && root.right == null){
            return root.val;
        }
        int leftSum = sumOfLeftLeaves(root.left, true);
        int rightSum = sumOfLeftLeaves(root.right, false);
        return leftSum + rightSum;
    }
}
