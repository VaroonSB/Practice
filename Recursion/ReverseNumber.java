class Main {
    public static void main(String[] args) {
        System.out.println(reverse(1342, 0));
    }

    static int reverse(int n, int reversed) {
        if (n == 0) {
            return reversed;
        }

        return reverse(n/10, reversed * 10 + n%10);
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(reverse(23314));
    }

    static int reverse(int n) {
        if (n % 10 == n) {
            return n;
        }

        int digits = (int)(Math.log10(n)) + 1;

        return n%10 * (int)Math.pow(10, digits-1) + reverse(n/10);
    }
}