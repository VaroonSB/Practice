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

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Handle edge cases: empty list or a list with a single node.
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Phase 1: Detect the cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break; // Cycle detected, break out of the loop
            }
        }

        // If the loop finished because fast reached null, there is no cycle.
        if (!hasCycle) {
            return null;
        }

        // Phase 2: Find the start of the cycle
        // Reset one pointer to the head, keep the other at the meeting point.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // When they meet again, that's the starting node of the cycle.
        return slow;
    }
}