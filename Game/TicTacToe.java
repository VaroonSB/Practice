import java.util.*;

class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }

        char player = 'x';
        boolean gameOver = false;

        while (!gameOver) {
            print(board);
            System.out.println("Player " + player + ", your turn");

            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] != '_') {
                System.out.println("Invalid Move");
                continue;
            }

            board[row][col] = player;
            gameOver = hasWon(board, player);

            if (gameOver) {
                System.out.println("Player " + player + " has won");
            } else {
                player = player == 'x' ? 'o' : 'x';
            }
        }
    }

    static void print(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean hasWon(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }

            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}