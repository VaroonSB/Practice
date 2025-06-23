import java.util.*;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

class BinaryTree {
    private Node root;

    public BinaryTree() {

    }

    public void populate(Scanner scanner) {
        System.out.println("Enter the root");
        int value = scanner.nextInt();
        this.root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        pretty();
        System.out.println("Do you want to enter left of " + node.value);
        int left = scanner.nextInt();
        if (left >= 0) {
            node.left = new Node(left);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to enter right of " + node.value);
        int right = scanner.nextInt();
        if (right >= 0) {
            node.right = new Node(right);
            populate(scanner, node.right);
        }
    }

    public void print() {
        print(root, "");
    }

    private void print(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        print(node.left, indent + "\t");
        print(node.right, indent + "\t");
    }

    public void pretty() {
        pretty(root, 0);
    }

    private void pretty(Node node, int level) {
        if (node == null) {
            return;
        }

        pretty(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-------> " + node.value);
        } else {
            System.out.println(node.value);
        }
        pretty(node.left, level + 1);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        tree.populate(scanner);

        tree.print();

        tree.pretty();
    }
}