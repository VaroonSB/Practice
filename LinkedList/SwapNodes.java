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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head;

        for (int i = 1; i < k; i++) {
            firstNode = firstNode.next;
        }

        ListNode temp = firstNode;

        while (temp.next != null) {
            secondNode = secondNode.next;
            temp = temp.next;
        }

        int tempVal = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tempVal;

        return head;
    }
}