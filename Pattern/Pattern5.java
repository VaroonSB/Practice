class Main {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= 2*n; i++) {
            int col = i <= n ? i : (2*n) - i;
            for (int j = 1; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}