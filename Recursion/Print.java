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

// wrong
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

class Main {
    public static void main(String[] args) {
        print(10);
    }

    static void print(int n) {
        if (n == 0) {
            return;
        }
        print(n-1);
        System.out.println(n + " ");
    }
}

// 10 t0 1 and 1 to 10
class Main {
    public static void main(String[] args) {
        print(10);
    }

    static void print(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n + " ");
        print(n-1);
        System.out.println(n + " ");
    }
}