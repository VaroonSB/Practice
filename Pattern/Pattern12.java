class Main {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= 2*n; i++) {
            int spaces = i <= n ? i - 1 : 2*n - i;
            for (int k = 1; k <= spaces; k++) {
                System.out.print(" ");
            }

            int col = i <= n ? n - i + 1 : i - n;
            for (int j = 1; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}