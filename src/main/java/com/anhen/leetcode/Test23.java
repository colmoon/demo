package com.anhen.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

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

    //方法二：分治，两两合并
    private ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    //通过mid将数组一分为二，并不断缩小规模，当规模为1时返回并开始合并
    //通过合并两个链表，不断增大其规模，整体看就是不断缩小-最后不断扩大的过程
    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }

    //迭代合并两条链表
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

    //
    //方法三：最小堆
    private ListNode mergeKLists3(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        //创建一个堆，并设置元素的排序方式
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        //遍历链表数组，然后将每个链表的每个节点都放入堆中
        for(int i=0;i<lists.length;i++) {
            while(lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        //从堆中不断取出元素，并将取出的元素串联起来
        while( !queue.isEmpty() ) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }
}
