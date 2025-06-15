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
class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;

        boolean once = false;

        while (true) {
            ListNode scout = current;
            int count = 0;
            while (count < k && scout != null) {
                scout = scout.next;
                count++;
            }

            if (count != k) {
                break;
            }
            ListNode newEnd = current;
            ListNode newStart = prev;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (!once) {
                head = prev;
                once = true;
            }

            newEnd.next = current;
            if (newStart != null) {
                newStart.next = prev;
            }
            prev = newEnd;

            if (current == null) {
                break;
            }
        }

        return head;
    }
}