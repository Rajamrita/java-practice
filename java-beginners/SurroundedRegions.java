public class SurroundedRegions {

    // DFS function
    public static void dfs(char[][] board, int row, int col) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != 'O') {

            return;
        }

        // Mark safe O as T
        board[row][col] = 'T';

        // Up
        dfs(board, row - 1, col);

        // Down
        dfs(board, row + 1, col);

        // Left
        dfs(board, row, col - 1);

        // Right
        dfs(board, row, col + 1);
    }

    // Solve the board
    public static void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // Check top and bottom rows
        for (int col = 0; col < cols; col++) {

            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }

            if (board[rows - 1][col] == 'O') {
                dfs(board, rows - 1, col);
            }
        }

        // Check left and right columns
        for (int row = 0; row < rows; row++) {

            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }

            if (board[row][cols - 1] == 'O') {
                dfs(board, row, cols - 1);
            }
        }

        // Convert surrounded O -> X
        // Convert T -> O
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }

                if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        solve(board);

        // Print the result
        System.out.println("Result:");

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }
}