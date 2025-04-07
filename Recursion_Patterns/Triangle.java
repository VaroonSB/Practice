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

class Main {
    public static void main(String[] args) {
        print(4, 1);
    }

    static void print(int row, int col) {

        if(row == 0) {
            return;
        }

        if (col <= row) {
            print(row, col+1);
            System.out.print("*");
        } else {
            print(row-1, 1);
            System.out.println();
        }
    }
}