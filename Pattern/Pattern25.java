class Main {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= n - i; k++) {
                System.out.print(" ");
            }

            for (int j = 1; j<= n; j++) {
                if (j== 1 || j == n || i == 1 || i == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}