class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }

    Node (int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "";
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
            System.out.print(temp + " -> ");
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

        Node temp = head;

        insertRec(index, data, temp);
    }

    Node insertRec(int index, int data, Node node) {
        if (index == 0) {
            Node newNode = new Node(data, node);
            return newNode;
        }

        node.next = insertRec(index-1, data, node.next);
        return node;
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

        list.insert(3, 19);
        list.print();

        System.out.println(list.get(3));
        System.out.println(list.get(0));
    }
}