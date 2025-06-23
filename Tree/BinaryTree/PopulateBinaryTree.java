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
        print();
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.left);
        }
    }

    public void print() {
        print(root, "");
    }

    public void print(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        print(node.left, indent + "\t");
        print(node.right, indent + "\t");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        tree.populate(scanner);

        tree.print();
    }
}