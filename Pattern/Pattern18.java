class Main {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= 2 * n; i++) {

            for (int j = 1; j <= 2 * n; j++) {

                int start = i <= n ? n - i + 2 : i - n + 1;
                int end = i <= n ? n + i - 1 : 2 * n - (i - n);

                if (j >= start && j <= end) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }

            System.out.println();
        }
    }
}