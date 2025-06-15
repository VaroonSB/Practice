/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        ListNode last = current;

        ListNode prev = null;
        current = head;
        for (int i = 0; i < length-k && current != null; i++) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
        last.next = head;
        head = current;
        return head;
    }
}