class Main {
    public static void main(String[] args) {
        int n = 4;
        int cols = n + (n-1);
        for (int i = 0; i < n; i++) {
            int start = (cols / 2) - i;
            int end = (cols / 2) + i;
            for (int j = 0; j <= end; j++) {
                if (j >= start && j <= end) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}