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

class Main {
    public static void main(String[] args) {
        print(10, 1);
    }

    static void print(int n, int i) {
        if (i > n) {
            return;
        }
        System.out.println(i + " ");
        print(n, i+1);
    }
}