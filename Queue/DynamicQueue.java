class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int start = 0;
    protected int end = 0;
    private int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    protected boolean isFull() {
        return size == data.length;
    }

    protected boolean isEmpty() {
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

class DynamicQueue extends CircularQueue {
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean push(int value) {
        if (isFull()) {
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(start+i) % data.length];
            }
            start = 0;
            end = data.length;
            data = temp;
        }
        return super.push(value);
    }
}

class Main {
    public static void main(String[] args) {
        CircularQueue q = new DynamicQueue(5);
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