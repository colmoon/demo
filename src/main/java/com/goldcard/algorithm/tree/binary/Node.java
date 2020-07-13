package com.goldcard.algorithm.tree.binary;

/**
 * @classname: Node
 * @description: node
 * @author: wuxiaojian
 * @create: 2020-07-13 10:48
 */
public class Node {
    /** 节点数据 */
    int data;
    /** 左子节点的引用 */
    Node leftChild;
    /** 右子节点的引用 */
    Node rightChild;
    /** 表示节点是否被删除 */
    boolean isDelete;

    public Node(int data){
        this.data = data;
    }

    /**
     * 打印节点内容
     **/
    public void display(){
        System.out.println(data);
    }
}
