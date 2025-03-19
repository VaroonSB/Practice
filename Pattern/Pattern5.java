class Main {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 0; i < 2*n+1; i++) {
            int col = i < n ? i : 2*n-i;
            for (int j = 0; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}