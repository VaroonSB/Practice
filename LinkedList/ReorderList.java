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
class ReorderList {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode firstHead = head;

        ListNode mid = getMid(head);
        ListNode secondHead = reverse(mid);

        while (firstHead != null && secondHead != null) {
            ListNode tempNext = firstHead.next;
            firstHead.next = secondHead;
            firstHead = tempNext;

            tempNext = secondHead.next;
            secondHead.next = firstHead;
            secondHead = tempNext;
        }

        if (firstHead != null) {
            firstHead.next = null;
        }
    }

    ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }

        ListNode temp = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return temp;
    }
}