class Node {
    int data;
    Node next;
    Node prev;

    Node (int data) {
        this.data = data;
        this.next = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}

class DoublyLinkedList {
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

        newNode.prev = temp;
        temp.next = newNode;
    }

    void addFirst (int data) {
        Node temp = new Node(data);
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
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

        while (temp.next != null && temp.data != data) {
            temp = temp.next;
        }
        System.out.println(temp);
        if (temp != null) {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
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
        while (temp.next != null && i < index) {
            temp = temp.next;
            i++;
        }
        temp.prev.next = newNode;
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev = newNode;
    }

    Node get(int index) {
        Node temp = head;

        int i = 0;
        while (temp.next != null && i < index) {
            temp = temp.next;
            i++;
        }

        return temp;
    }
}

class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

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

        list.insert(3, 11);
        list.print();

        System.out.println(list.get(5));
        System.out.println(list.get(0));
    }
}