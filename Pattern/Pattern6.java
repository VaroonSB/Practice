class Main {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= n; i++) {
            int spaces = n - i;

            for (int k = 1; k <= spaces; k++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}