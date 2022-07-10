package com.moon.demo.leetcode.tree;

import com.moon.demo.leetcode.tree.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @classname: Test173
 * @description:
 * 173. 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *
 *
 * 示例：
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 * @author: wuxiaojian
 * @create: 2020-07-14 13:16
 */

public class BSTIterator {

    private Queue<Integer> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        infixOrder(root);
    }

    /**
     * 中序遍历
     * @param current:
     **/
    private void infixOrder(TreeNode current) {
        if (current != null) {
            infixOrder(current.left);
            queue.add(current.val);
            infixOrder(current.right);
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

}