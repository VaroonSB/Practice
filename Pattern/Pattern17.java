class Main {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= 2 * n; i++) {

            int spaces = i <= n ? n - i : i - n;
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            int col = i <= n ? i : 2 * n - i;
            for (int j = col; j >= 1; j--) {
                System.out.print(j);
            }

            for (int j = 2; j <= col; j++) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}