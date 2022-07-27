package common;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
    }

    public static ListNode create(int... arr) {
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int j : arr) {
            tail = tail.next = new ListNode(j);
        }
        return head.next;
    }
}
