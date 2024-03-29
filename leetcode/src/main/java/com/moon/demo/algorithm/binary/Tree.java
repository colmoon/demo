package com.moon.demo.algorithm.binary;

/**
 * @classname: Tree
 * @description: tree
 * @author: wuxiaojian
 * @create: 2020-07-13 10:48
 */

public interface Tree {
    //查找节点
    Node find(int key);
    //插入新节点
    boolean insert(int data);

    //中序遍历
    void infixOrder(Node current);
    //前序遍历
    void preOrder(Node current);
    //后序遍历
    void postOrder(Node current);

    //查找最大值
    Node findMax();
    //查找最小值
    Node findMin();

    //删除节点
    boolean delete(int key);
}
