class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    static boolean backtrack(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean isSolved = true;

        // find an empty cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    isSolved = false;
                    break;
                }
            }

            if (!isSolved) {
                break; // for outer loop as well
            }
        }

        if (isSolved) {
            return true; // winning condition;
        }

        for (int i = 1; i <= 9; i++) {
            char ch = (char) (i + '0');
            if (isSafe(board, row, col, ch)) {
                board[row][col] = ch;
                if (backtrack(board)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    static boolean isSafe(char[][] board, int row, int col, char number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number) {
                return false;
            }
            if (board[i][col] == number) {
                return false;
            }
        }

        int initRowSubBox = row - (row % 3);
        int initColSubBox = col - (col % 3);

        for (int i = initRowSubBox; i < initRowSubBox + 3; i++) {
            for (int j = initColSubBox; j < initColSubBox + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }
}