package com.anhen.leetcode.list;



/**
 * @classname: Test02
 * @description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: wuxiaojian
 * @create: 2020-06-04 17:01
 */
public class Test02 {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //自己解法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode listNode = null;
        int adding = 0;
        while (l1 != null || l2 != null || adding == 1){
            int result = 0;
            if (l1 != null && l2 != null){
                result = l1.val + l2.val + adding;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null){
                result = l1.val + adding;
                l1 = l1.next;
            } else if (l2 != null){
                result = l2.val + adding;
                l2 = l2.next;
            } else {
                result = adding;
            }
            adding = result/10;
            result = result % 10;
            ListNode temp = new ListNode(result);
            if (head == null){
                head = temp;
                listNode = temp;
            } else {
                listNode.next = temp;
                listNode = listNode.next;
            }
        }
        return head;
    }

    // 官方解法
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 !=null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            cur.next = new ListNode(carry);
        }
        return head.next;
    }


}
