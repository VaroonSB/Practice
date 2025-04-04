class Main {

    static int n = 4;

    public static void main(String[] args) {
        print(1, 1);
    }

    static void print(int row, int col) {

        if (row > n) {
            return;
        }

        if (col <= row) {
            System.out.print("*");
            print(row, col+1);
        } else {
            System.out.println();
            print(row+1, 1);
        }
    }

}