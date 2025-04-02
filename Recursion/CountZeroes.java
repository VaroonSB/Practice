class Main {
    public static void main(String[] args) {
        System.out.println(countZeroes(400102));
    }

    static int countZeroes(int n) {

        if (n == 0) {
            return 0;
        }

        if (n % 10 == 0) {
            return countZeroes(n/10) + 1;
        } else {
            return countZeroes(n/10) + 0;
        }
    }
}