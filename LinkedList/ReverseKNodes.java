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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }

        ListNode start = head, end = head;
        ListNode dummy = new ListNode(0, head); // use to return the head at last
        ListNode prev = dummy;

        while (true) {

            // traverse till next k nodes
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }

            // we have hit the end of the list
            if (end == null) {
                break;
            }

            // store next start and the connector for start
            ListNode next = end.next;

            // break the end. connect later
            end.next = null;

            ListNode revHead = reverse(start);

            // connections
            prev.next = revHead; // left side
            start.next = next; // right side

            // set stage for next set of k nodes
            prev = start;
            start = prev.next;
            end = prev.next;
        }

        return dummy.next; // peace
    }

    ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}