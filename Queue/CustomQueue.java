class Queue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    private int end = 0;

    public Queue() {
        this(DEFAULT_SIZE);
    }

    public Queue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    private boolean isEmpty() {
        return end == 0;
    }

    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        data[end++] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removed = data[0];
        for (int i = 1; i < data.length; i++) {
            data[i-1] = data[i];
        }
        data[data.length - 1] = 0;
        end--;
        return removed;
    }

    public void print() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " -> ");
        }
        System.out.println();
    }

    public void peek() {
        System.out.println("PEEK: " + data[0]);
    }
}

class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.pop();
        q.push(4);
        q.push(3);
        q.push(2);
        q.print();

        q.push(1);
        q.push(6);
        q.push(7);
        q.print();

        q.peek();
        q.pop();
        q.print();
        q.peek();
    }
}