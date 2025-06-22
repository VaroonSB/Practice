class MyStack {

    Queue<Integer> first;
    Queue<Integer> second;

    public MyStack() {
        this.first = new LinkedList<>();
        this.second = new LinkedList<>();
    }

    public void push(int x) {
        first.offer(x);
    }

    public int pop() {
        while (first.size() != 1) {
            second.offer(first.poll());
        }

        int removed = first.poll();

        while (!second.isEmpty()) {
            first.offer(second.poll());
        }

        return removed;
    }

    public int top() {
        while (first.size() != 1) {
            second.offer(first.poll());
        }

        int top = first.peek();
        second.offer(first.poll());

        while (!second.isEmpty()) {
            first.offer(second.poll());
        }

        return top;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */