class Main {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i - 1; k++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * (n-i) + 1; j++) {
                if (j == 1 || j == 2 * (n-i) + 1 || i == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}