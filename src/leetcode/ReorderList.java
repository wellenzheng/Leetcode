package leetcode;

import common.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        //寻找链表中点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        //反转右半部分
        ListNode pre = null, curr = mid;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        //拼接
        ListNode left = head, right = pre;
        while (left != null && right != null) {
            ListNode lnext = left.next;
            ListNode rnext = right.next;
            left.next = right;
            right.next = lnext;
            left = lnext;
            right = rnext;
        }
    }

    public static void main(String[] args) {

    }
}
