package com.moon.demo.leetcode.list;

/**
 * @classname: ReverseListPair
 * @description: 1.自定义一个链表数据结构，并对该链表实现两两翻转。
 * 比如构造的链表是：1->2->3->4->5，翻转之后输出：2->1->4->3->5
 * @author: wuxiaojian
 * @create: 2021-04-29 10:41
 */
public class ReverseListPair {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(30);
        ListNode a4 = new ListNode(78);
        ListNode a5 = new ListNode(99);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        //反转单链表
        ListNode node = reverse(a1);

        //打印输出结果
        while (node != null){
            System.out.print(node.val);
            node = node.next;
            System.out.print(node != null ? "->" : "");
        }
    }

    public static ListNode reverse(ListNode list){
        ListNode first = list;  ListNode third; ListNode head = list.next == null ? list : list.next;

        while (first != null && first.next != null){
            //记录第三个节点
            third = first.next.next;
            //一 二节点互换位置
            first.next.next = first;
            //一 节点指向第四个节点
            if (third != null && third.next != null){
                first.next = third.next;
            } else {
                first.next = third;
            }
            //下一组
            first = third;
        }
        return head;
    }
}
