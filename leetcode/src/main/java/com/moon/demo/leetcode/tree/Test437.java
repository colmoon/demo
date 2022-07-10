package com.moon.demo.leetcode.tree;

import com.moon.demo.leetcode.tree.model.TreeNode;

/**
 * @classname: Test437
 * @description:
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * @author: wuxiaojian
 * @create: 2020-07-14 17:07
 */
public class Test437 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(-2);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(1);
        treeNode.right = new TreeNode(-3);
        treeNode.right.right = new TreeNode(11);
        Test437 test437 = new Test437();
        System.out.println(test437.pathSum(treeNode, 8));
    }

    public int count = 0;

    public int pathSum(TreeNode root, int sum) {
        isSubPath(root, sum);
        return count;
    }

    public void isSubPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        int result = 0;
        //使用 bfs 找到起点
        //使用 dfs 匹配
        isSub(root, sum, result + root.val);
        isSubPath(root.left, sum);
        isSubPath(root.right, sum);
    }

    private void isSub(TreeNode root, int sum, int result) {
        if (result == sum) {
            count++;
            //这里不需要return，继续往下找符合sum也算一次路径
        }
        if (root.left != null){
            isSub(root.left, sum, result + root.left.val);
            //这里不需要恢复现场,因为新加的val值没有赋值到这一层的result
        }
        if (root.right != null){
            isSub(root.right, sum, result + root.right.val);
        }
    }

    //方法2
    public int pathSum2(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int result = countPath(root,sum);
        int a = pathSum2(root.left,sum);
        int b = pathSum2(root.right,sum);
        return result+a+b;

    }
    public int countPath(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        sum = sum - root.val;
        int result = sum == 0 ? 1:0;
        return result + countPath(root.left,sum) + countPath(root.right,sum);
    }
}
