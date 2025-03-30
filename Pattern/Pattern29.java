class Main {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= 2*n; i++) {
            int start = i <= n ? i : (2*n - i);
            int end = i <= n ? (2*n - i + 1) : i + 1;
            for (int j = 1; j <= 2*n; j++) {
                if (j > start && j < end && i != n) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}