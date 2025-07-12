/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        solution(root);
        return root;
    }

    static Node solution(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            node.left.next = node.right;
        }

        if (node.right != null && node.next != null) {
            node.right.next = node.next.left;
        }
        solution(node.left);
        solution(node.right);

        return node;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }
}