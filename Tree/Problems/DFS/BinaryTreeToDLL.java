/* class Node
class Node
{
    Node left, right;
    int data;

    Node(int d)
    {
        data = d;
        left = right = null;
    }

}*/

// This function should return head to the DLL

class Solution {
    Node head;
    Node tail;
    // Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root) {
        //  Your code here
        helper(root);

        return head;
    }

    void helper(Node node) {
        if (node == null) {
            return;
        }

        helper(node.left);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.right = node;
            node.left = tail;
            tail = node;
        }

        helper(node.right);
    }
}