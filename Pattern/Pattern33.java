class Main {
    public static void main(String[] args) {
        int n = 5;
        int ASCII = 97;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((char)(count + ASCII) + " ");
                ASCII = ASCII == 97 ? 65 : 97;
                count++;
            }

            System.out.println("");
        }
    }
}