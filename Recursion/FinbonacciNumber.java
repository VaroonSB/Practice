class Main {
    public static void main(String[] args) {
        System.out.print(fibonacci(4));
    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}