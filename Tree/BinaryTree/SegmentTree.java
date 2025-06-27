import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;

    int leftInterval;
    int rightInterval;

    public Node(int leftInterval, int rightInterval) {
        this.leftInterval = leftInterval;
        this.rightInterval = rightInterval;
    }
}

class SegmentTree {

    Node root;

    public SegmentTree(int[] arr) {
        // create SegmentTree here
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    Node constructTree(int[] arr, int leftInterval, int rightInterval) {

        if (leftInterval == rightInterval) {
            Node leaf = new Node(leftInterval, rightInterval);
            leaf.data = arr[leftInterval];
            return leaf;
        }

        Node node = new Node(leftInterval, rightInterval);

        int mid = leftInterval + (rightInterval - leftInterval) / 2;

        node.left = constructTree(arr, leftInterval, mid);
        node.right = constructTree(arr, mid + 1, rightInterval);

        node.data = node.left.data + node.right.data;
        return node;

    }

    public void display() {
        display("\n\nRoot: ",this.root);
    }

    private void display(String label, Node node) {
        if (node == null) {
            return;
        }

        System.out.println(label + node.data + " | Range: [ " + node.leftInterval + ", " + node.rightInterval + " ]");
        display("left of " + node.data + " : ", node.left);
        display("right of " + node.data + " : ", node.right);
    }

    public int query(int qsi, int qei) {
        int result = query(this.root, qsi, qei);
        System.out.println("Query of [ " + qsi + ", " + qei + " ] -> " + result);
        return result;
    }

    private int query(Node node, int qsi, int qei) {
        if (node.leftInterval >= qsi && node.rightInterval <= qei) {
            // node is completely inside the query range
            return node.data;
        } else if (node.leftInterval > qei || node.rightInterval < qsi) {
            // completely outside query range
            return 0;
        } else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.leftInterval && index <= node.rightInterval) {
            if (index == node.leftInterval && index == node.rightInterval) {
                // leaf node reached - update the value here
                node.data = value;
            } else {
                // go left and right until leaf and recurse way back while summing up
                node.data = update(node.left, index, value) + update(node.right, index, value);
            }
        }
        // return updated data if its eligible for update
        // otherwise just return same data
        return node.data;
    }
}

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] arr = {3, 8, 6, 7, 2, -8, 4, 9};

        SegmentTree tree = new SegmentTree(arr);
        tree.display();

        tree.query(1, 7);

        tree.update(4, 8);

        tree.display();

    }
}
