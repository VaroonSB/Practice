class Main {
    public static void main(String[] args) {
        int n = 4;
        printPattern(n);
    }

    public static void printPattern(int n) {
        int count = 1;
        int end = 20;
        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= i - 1; k++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(count + " ");
                count++;
            }

            if (i != n) {
                System.out.print(" ");
            }

            for (int j = end - (n - i); j <= end; j++) {
                System.out.print(j + " ");
            }

            end -= (n-i + 1);

            System.out.println();

        }
    }
}