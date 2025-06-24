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
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;

        ListNode evenHead = node2;

        while (node2 != null && node2.next != null) {
            node1.next =  node2.next;
            node1 = node1.next;
            node2.next = node1.next;
            node2 = node2.next;
        }

        node1.next = evenHead;

        return head;
    }
}