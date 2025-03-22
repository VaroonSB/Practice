class Main {
    public static void main(String[] args) {
        // int ogN = 5;
        int n = 2*5;
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                // int left = col;
                // int right = n - col;
                // int up = row;
                // int down = n - row;
                int value = 5 - Math.min(Math.min(col, row), Math.min(n-col, n-row)) + 1;
                System.out.print(value + " ");
            }
            System.out.println("");
        }
    }
}