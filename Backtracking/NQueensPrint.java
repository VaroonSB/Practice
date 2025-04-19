class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        queens(board, 0, result);
        return result;
    }

    static void queens(boolean[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(addBoardToResult(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                queens(board, row+1, result);
                board[row][col] = false;
            }
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col) {

        // straight up
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]) {
                return false;
            }
        }

        // right diagonal
        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row-i][col+i]) {
                return false;
            }
        }

        return true;
    }

    static List<String> addBoardToResult(boolean[][] board) {
        List<String> boardString = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            char[] row = new char[board.length];
            Arrays.fill(row, '.');
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    row[j] = 'Q';
                }
            }
            boardString.add(new String(row));
        }

        return boardString;
    }
}