class Main {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < 2*n+1; i++) {
            int col = i < n ? i : 2*n-i;

            int spaces = n - col;

            for (int k = 0; k < spaces; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}