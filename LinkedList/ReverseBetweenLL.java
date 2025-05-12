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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        for (int i = 0; i < left-1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode newEnd = current;
        ListNode last = prev;

        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        newEnd.next = current;

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        return head;
    }
}