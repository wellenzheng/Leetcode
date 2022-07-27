package leetcode;

import common.ListNode;

import java.util.Stack;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> s3 = new Stack<>();
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            s3.push(sum % 10);
        }
        if (carry != 0) {
            s2.push(carry);
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (!s3.isEmpty()) {
            curr = curr.next = new ListNode(s3.pop());
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = addTwoNumbers(ListNode.create(7, 2, 4, 3), ListNode.create(5, 6, 4));
        ListNode.print(listNode);
    }
}
