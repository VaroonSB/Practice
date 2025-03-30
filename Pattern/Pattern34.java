class Main {
    public static void main(String[] args) {
        int n = 5;
        int ASCII = 65;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print((char)((n - i - j + 1) + ASCII) + " ");
            }

            System.out.println("");
        }
    }
}