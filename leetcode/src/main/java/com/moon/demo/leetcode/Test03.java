package com.moon.demo.leetcode;

import java.util.ArrayList;

/**
 * @ClassName Test03
 * @Description
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author wuxiaojian
 * @Date 2020/5/12 21:36
 * @Version 1.0
 **/

public class Test03 {
    public static void main(String[] args) {

    }

    private ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = listNode;
        while (node != null){
            list.add(node.val);
            node = node.next;
        }
        int length = list.size();
        if (length > 0){
            for (int i = 0 ; i < list.size()/2; i++){
                int temp = list.get(length -i -1);
                list.set(length - i -1, list.get(i));
                list.set(i, temp);
            }
        }
        return list;
    }

    /**
     * @Author wuxiaojian
     * @Description 链表原址反转
     * @Date  2020/5/12 22:50
     * @Param [listNode]
     * @return java.util.ArrayList<java.lang.Integer>
     **/
    private ArrayList<Integer> printListFromTailToHead02(ListNode listNode) {
        ListNode pre = null;
        ListNode next;
        while (listNode != null){
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (pre != null){
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
