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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode headPrev = new ListNode();
        headPrev.next = head;
        ListNode prev = headPrev, one = head, two = head.next;
        while (true) {
            ListNode next = two.next;
            two.next = one;

            one.next = next; // right
            prev.next = two; // left

            prev = one;
            if (prev.next == null || prev.next.next == null) {
                break;
            }
            one = prev.next;
            two = prev.next.next;
        }

        return headPrev.next;
    }
}