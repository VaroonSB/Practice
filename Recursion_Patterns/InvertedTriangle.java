class Main {

    static int n = 4;

    public static void main(String[] args) {
        printInvert(1, 1);
    }

    static void printInvert(int row, int col) {

        if (row > n) {
            return;
        }

        if (col <= n - row + 1) {
            System.out.print("*");
            printInvert(row, col+1);
        } else {
            System.out.println();
            printInvert(row+1, 1);
        }
    }

}

class Main {
    public static void main(String[] args) {
        print(4, 1);
    }

    static void print(int row, int col) {

        if(row == 0) {
            return;
        }

        if (col <= row) {
            System.out.print("*");
            print(row, col+1);
        } else {
            System.out.println();
            print(row-1, 1);
        }
    }
}