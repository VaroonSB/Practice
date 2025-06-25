import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int value;
    Node left;
    Node right;
    int height;

    public Node(int value) {
        this.value = value;
    }
}

class AVL {
    Node root;

    public int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            return newNode;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left left - right rotate
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0){
                // left right - left and right rotate
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.right) - height(node.right.left) > 0) {
                // right right - left rotate
                return leftRotate(node);
            }
            if (height(node.right.right) - height(node.right.left) < 0){
                // right left - right and left rotate
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node parent) {
        Node child = parent.left;
        Node t2 = child.right;
        child.right = parent;
        parent.left = t2;

        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
    }

    private Node leftRotate(Node parent) {
        Node child = parent.right;
        Node t2 = child.left;
        child.left = parent;
        parent.right = t2;

        parent.height = Math.max(height(parent.left), height(parent.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        return child;
    }

    public void display() {
        display(root, "root node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + ": " + node.value + " height: " + node.height);
        display(node.left, "left of " + node.value);
        display(node.right, "right of " + node.value);
    }

    public boolean isBalanced() {
        boolean balanced = isBalanced(root);
        System.out.println("\nBalanced: " + balanced);
        return balanced;
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }
}

class Codechef {
    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(1);
        avl.insert(2);
        avl.insert(0);
        avl.insert(7);
        avl.insert(6);
        avl.insert(8);
        avl.insert(9);
        avl.insert(-1);
        avl.isBalanced();
        avl.insert(10);
        avl.display();
        avl.isBalanced();
    }
}
