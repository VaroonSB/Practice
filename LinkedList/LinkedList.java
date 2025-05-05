class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void add (int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void addFirst (int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void remove(int data) {

        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    void insert(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;

        int i = 0;
        while (temp.next != null && i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    int get(int index) {
        Node temp = head;

        int i = 0;
        while (temp.next != null && i < index) {
            temp = temp.next;
            i++;
        }

        return temp.data;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(2);
        list.add(9);
        list.add(6);
        list.add(1);

        list.print();

        list.remove(9);
        list.print();

        list.addFirst(7);
        list.print();

        list.insert(0, 10);
        list.print();

        System.out.println(list.get(3));
        System.out.println(list.get(0));
    }
}