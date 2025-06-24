import java.util.*;

class Node {
    int value;
    Node left;
    Node right;
    int height;

    public Node(int value) {
        this.value = value;
    }
}

class BST {
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

        return node;
    }

    public void display() {
        display(root, "root node: ");

        System.out.println("\n\nInorder\n");
        inorder(root);

        System.out.println("\n\nPreorder\n");
        preorder(root);

        System.out.println("\n\nPostorder\n");
        postorder(root);
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
        System.out.println("Balanced: " + balanced);
        return balanced;
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }
}

class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(1);
        bst.insert(2);
        bst.insert(0);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);
        bst.insert(9);
        bst.insert(-1);
        // bst.insert(10);
        bst.display();
        bst.isBalanced();
    }
}