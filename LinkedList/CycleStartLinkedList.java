/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// think I don't need to compute length and move the new pointers.
// once cycle is found, until slow meets fast again, move a new pointer
// from head and that would be the start point.
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                do {
                    slow = slow.next;
                    length++;
                } while (fast != slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // take two pointers and move one to length
        fast = head;
        slow = head;
        while (length > 0) {
            length--;
            slow = slow.next;
        }

        // then move them one by one. when they meet its the start
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow; // or fast;
    }
}