class Main {
    public static void main(String[] args) {
        int n = 10; // Number of rows in the pattern
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<= n; j++) {
                if (j== 1 || j == n || i == j || (n - i + 1) == j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}