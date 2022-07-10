package com.moon.demo.leetcode.tree;

import com.moon.demo.leetcode.tree.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @classname: Test101
 * @description:
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * @author: wuxiaojian
 * @create: 2020-07-15 18:04
 */
public class Test101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        } else if (p == null || q == null){
            return false;
        } else if (p.val == q.val){
            return isMirror(p.left, q.right) && isMirror(p.right, q.left);
        } else {
            return false;
        }
    }

    public boolean isMirror2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()){
            TreeNode m = queue.poll();
            TreeNode n = queue.poll();
            if (m == null && n == null){
                continue;
            }
            if (m == null || n == null){
                return false;
            }
            if (m.val == n.val){
                queue.add(m.left);
                queue.add(n.right);
                queue.add(m.right);
                queue.add(n.left);
            } else {
                return false;
            }
        }
        return true;
    }
}
