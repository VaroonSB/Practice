class Main {
    public static void main(String[] args) {
        System.out.println(productOfDigits(1342));
    }

    static int productOfDigits(int n) {
        if (n == 0) {
            return 1;
        }
        return n%10 * productOfDigits(n/10);
    }
}