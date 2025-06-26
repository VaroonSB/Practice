import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int value;
    Node left;
    Node right;
    int height;

    public Node (int value) {
        this.value = value;
    }
}

class BST {
    private Node root;

    public int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    public Node insert(int value, Node node) {
        if (node == null) {
            Node newNode = new Node(value);
            return newNode;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void display() {
        display("root: ", root);
    }

    private void display(String label, Node node) {
        if (node == null) {
            return;
        }

        System.out.println(label + node.value + " || height: " + node.height);
        display("left of " + node.value + ": ", node.left);
        display("right of " + node.value + ": ", node.right);
    }

    public boolean isBalanced() {
        boolean balanced = isBalanced(root);
        System.out.println("Balanced: " + isBalanced(root));
        return balanced;
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return (Math.abs(height(node.left) - height(node.right)) <= 1) && isBalanced(node.left) && isBalanced(node.right);
    }
}

class AVL extends BST {

    @Override
    public Node insert(int value, Node node) {
        if (node == null) {
            Node newNode = new Node(value);
            return newNode;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left - right rotation
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left-right - left and right rotation
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.right) - height(node.left) > 1) {
            // right heavy
            if (height(node.right.right) - height(node.right.left) > 0) {
                // right-right - left rotation
                return leftRotate(node);
            }
            if (height(node.right.right) - height(node.right.left) < 0) {
                // right-left - right and left rotate
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node leftRotate(Node parent) {
        Node child = parent.right;
        Node t2 = child.left;

        child.left = parent;
        parent.right = t2;

        return child;
    }

    private Node rightRotate(Node parent) {
        Node child = parent.left;
        Node t2 = child.right;

        child.right = parent;
        parent.left = t2;

        return child;
    }
}

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        AVL bst = new AVL();
        bst.insert(7);
        bst.insert(5);
        bst.insert(9);
        bst.insert(2);
        bst.insert(3);
        bst.insert(8);
        // 		bst.insert(6);
        bst.display();
        bst.isBalanced();
    }
}
