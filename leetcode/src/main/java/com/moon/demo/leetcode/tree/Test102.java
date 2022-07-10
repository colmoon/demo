package com.moon.demo.leetcode.tree;

import com.moon.demo.leetcode.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @classname: Test102
 * @description:
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @author: wuxiaojian
 * @create: 2020-07-13 20:01
 */
public class Test102 {
    public static void main(String[] args) {

    }

    /**
     * 维护两个Node类型的遍历last（当前行的最右结点），nlast（下一行的最右结点）。
     * 当队列中弹出的值等于last的时候就知道该换行了，同时更新last
     * @param root: root
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        TreeNode nLast = null;
        TreeNode last = root;
        List<Integer> level = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            level.add(current.val);
            if (current.left != null){
                queue.add(current.left);
                nLast = current.left;
            }
            if (current.right != null){
                queue.add(current.right);
                nLast = current.right;
            }
            if (last == current){
                result.add(level);
                level = new ArrayList<>();
                last = nLast;
            }
        }
        return result;
    }

    /**
     * 借用队列的长度来判断层数
     * @param root: root
     **/
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                level.add(current.val);
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 采用深度优先遍历
     * @param root: root
     **/
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        dfs(1, root, result);
        return result;
    }

    /**
     * 深度优先遍历，加入index作为层数
     * @param index:
     * @param treeNode:
     * @param result:
     **/
    public void dfs(int index, TreeNode treeNode, List<List<Integer>> result){
        if (result.size() < index){
            result.add(new ArrayList<>());
        }
        result.get(index - 1).add(treeNode.val);
        if (treeNode.left != null){
            dfs(index + 1, treeNode.left, result);
        }
        if (treeNode.right != null){
            dfs(index + 1, treeNode.right, result);
        }
    }
}
