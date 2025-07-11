package TreePractice;

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
    Queue<Node> queue;
    List<List<Integer>> list;

    public BST() {
        this.queue = new LinkedList<>();
        this.list = new ArrayList<>();
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public void insert(int value) {
        this.root = this.insert(this.root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public void print() {
        this.print("Root: ", root);
    }

    private void print(String label, Node node) {
        if (node == null) {
            return;
        }

        System.out.println(label + node.value + " height: " + node.height);
        print("left of " + node.value + " : ", node.left);
        print("right of " + node.value + " : ", node.right);
    }

    public void BFS() {
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // add the level of element to the list
            list.add(currentLevel);
        }

        for (List<Integer> level : list) {
            System.out.println(level.toString());
        }
    }
}

public class BFS {
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
        bst.insert(10);
        bst.print();
        bst.BFS();
    }
}
