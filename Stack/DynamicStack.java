class Stack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int ptr = -1;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return ptr == (data.length - 1);
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }
        data[++ptr] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return data[ptr--];
    }

    public void peek() {
        System.out.println("PEEK: " + data[ptr]);
    }

    public void print() {
        for (int i = 0; i <= ptr; i++) {
            System.out.print(data[i] + " -> ");
        }
        System.out.println();
    }
}

class DynamicStack extends Stack {
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int value) {
        if (isFull()) {
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.push(value);
    }
}

class Main {
    public static void main(String[] args) {
        // Stack st = new Stack(5);
        DynamicStack st = new DynamicStack(5);
        st.pop();
        st.push(3);
        st.push(6);
        st.push(1);
        st.push(8);
        st.push(10);
        st.push(11);
        st.push(18);
        st.peek();
        st.print();

        st.pop();
        st.print();

        st.peek();
    }
}