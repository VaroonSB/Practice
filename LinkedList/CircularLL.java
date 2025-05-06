class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}

class CircularLL {
    Node head;
    Node tail;

    void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = tail;
            tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    void removeFirst() {
        tail.next = head.next;
        head = head.next;
    }

    void print() {
        Node current = head;
        do {
            System.out.print(current + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("HEAD");
    }

    void insert(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = get(index - 1);

        newNode.next = current.next;
        current.next = newNode;
    }

    Node get(int index) {
        Node current = head;
        int i = 0;
        do {
            if (i == index) {
                break;
            }
            current = current.next;
            i++;
        } while (current != head);

        return current;
    }

    void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }

        Node current = get(index - 1);
        current.next = current.next.next;
    }

    void pointers() {
        System.out.println(head);
        System.out.println(head.next);
        System.out.println(tail);
        System.out.println(tail.next);
    }
}

class Main {
    public static void main(String[] args) {
        CircularLL list = new CircularLL();
        list.add(3);
        list.add(5);
        list.add(6);
        list.print();

        list.addFirst(9);
        list.print();

        list.insert(2, 20);
        list.print();

        list.insert(0, 10);
        list.print();

        // case remaining as size is not calc, we can't reassign tail. Do it.
        // list.insert(6, 17);
        // list.print();

        list.remove(2);
        list.print();

        list.remove(0);
        list.print();

        list.pointers();
    }
}