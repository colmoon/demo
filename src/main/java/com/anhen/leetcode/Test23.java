package com.anhen.leetcode;

/**
 * @ClassName Test23
 * @Description
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * @Author wuxiaojian
 * @Date 2020/6/28 21:00
 * @Version 1.0
 **/

public class Test23 {
    public static void main(String[] args) {

    }


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //方法一：逐一合并两条链表
    private ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode listNode : lists){
            res = mergeTwoLists(res, listNode);
        }
        return res;
    }

    //方法一：逐一合并两条链表
    private  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            result = result.next;
        }
        result.next = l1 == null ? l2 : l1;

        return head.next;
    }
}
