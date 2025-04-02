class Main {
    public static void main(String[] args) {
        print(19);
    }

    static void print(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n + " ");
        print(n-1);
    }
}