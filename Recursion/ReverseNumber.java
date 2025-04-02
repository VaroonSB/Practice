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