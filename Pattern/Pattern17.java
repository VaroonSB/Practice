class Main {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= 2*n; i++) {
            int spaces = i <= n ? n - i : i - n;

            for (int k = 1; k <= spaces; k++) {
                System.out.print("  ");
            }

            int col = i < n ? i : 2*n - i;
            for (int k = col; k >= 1; k--) {
                System.out.print(k+" ");
            }
            for (int k = 2; k <= col; k++) {
                System.out.print(k+" ");
            }

            System.out.println("");
        }
    }
}