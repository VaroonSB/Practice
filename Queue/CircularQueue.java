class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    private int start = 0;
    private int end = 0;
    private int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    private boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        data[end++] = value;
        end = end % data.length;
        size++;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removed = data[start];
        start++;
        start = start % data.length;
        size--;

        return removed;
    }

    public void peek() {
        System.out.println("PEEK: " + data[start]);
    }

    public void print() {
        int temp = start;
        do {
            System.out.print(data[temp] + " -> ");
            temp++;
            temp = temp % data.length;
        } while (temp != end);
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
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