package com.moon.demo.leetcode.list;

/**
 * @ClassName Test206
 * @Description 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @Author wuxiaojian
 * @Date 2021/4/26 21:19
 * @Version 1.0
 **/

public class Test206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
