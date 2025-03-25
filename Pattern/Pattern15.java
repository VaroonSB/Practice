class Main {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= 2*n; i++) {
            int spaces = i <= n ? n - i : i - n;
            for (int k = 1; k <= spaces; k++) {
                System.out.print(" ");
            }

            int end = i <= n ? 2 * i - 1 : 2 * (2*n-i) - 1;
            for (int j = 1; j <= end; j++) {
                if (j == 1 || j == end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}