import java.util.*;

class Main {

    static int n = 4;

    public static void main(String[] args) {
        boolean[][] board = new boolean[n][n];

        knights(board, 0, 0, 0);
    }

    static void knights(boolean[][] board, int row, int col, int knights) {
        if (knights == n) {
            print(board);
            return;
        }

        if (row == n-1 && col == n) {
            return;
        }

        if (col == n) {
            knights(board, row+1, 0, knights);
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knights(board, row, col+1, knights+1);
            board[row][col] = false;
        }
        knights(board, row, col+1, knights);
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(row-1, col+2)) {
            if (board[row-1][col+2]) {
                return false;
            }
        }

        if(isValid(row-1, col-2)) {
            if (board[row-1][col-2]) {
                return false;
            }
        }

        if(isValid(row-2, col+1)) {
            if (board[row-2][col+1]) {
                return false;
            }
        }

        if(isValid(row-2, col-1)) {
            if (board[row-2][col-1]) {
                return false;
            }
        }

        return true;
    }

    static boolean isValid(int row, int col) {
        if (row >= 0 && row < n && col >= 0 && col < n) {
            return true;
        }

        return false;
    }

    static void print(boolean[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    System.out.print("K ");
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }


}