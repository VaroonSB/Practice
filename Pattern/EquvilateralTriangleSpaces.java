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

class Main {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 0; i < n; i++) {
            int spaces = n - i;

            for (int k = 1; k < spaces; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}

class Main {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            int spaces = n - i;

            for (int k = 1; k < spaces; k++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i+1; j++) {
                for (int k = i+1; k >= j; k--) {
                    System.out.print(+k+" ");
                }
                for (int k = j+1; k <= i+1; k++) {
                    System.out.print(k+" ");
                }
                break;
            }
            System.out.println("");
        }
    }
}