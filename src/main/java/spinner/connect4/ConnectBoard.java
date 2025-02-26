package spinner.connect4;

public class ConnectBoard
{
        private int width;
        private int height;
        private char[][] board;

        public ConnectBoard(int width, int height) {
            this.width = width;
            this.height = height;
            this.board = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    board[i][j] = ' '; // Initialize the board with empty spaces
                }
            }
        }

        public void insert(int column, char color) {
            if (column < 0 || column >= width) {
                throw new IllegalArgumentException("Column out of bounds");
            }
            for (int row = height - 1; row >= 0; row--) {
                if (board[row][column] == ' ') {
                    board[row][column] = color;
                    return;
                }
            }
            throw new IllegalArgumentException("Column is full");
        }

        public char calculateWinner() {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width - 3; col++) {
                    char color = board[row][col];
                    if (color != ' '
                            && color == board[row][col + 1]
                            && color == board[row][col + 2]
                            && color == board[row][col + 3]) {
                        return color;
                    }
                }
            }

            for (int col = 0; col < width; col++) {
                for (int row = 0; row < height - 3; row++) {
                    char color = board[row][col];
                    if (color != ' ' && color == board[row + 1][col] && color == board[row + 2][col] && color == board[row + 3][col]) {
                        return color;
                    }
                }
            }

            for (int row = 3; row < height; row++) {
                for (int col = 0; col < width - 3; col++) {
                    char color = board[row][col];
                    if (color != ' ' && color == board[row - 1][col + 1] && color == board[row - 2][col + 2] && color == board[row - 3][col + 3]) {
                        return color;
                    }
                }
            }
            for (int row = 0; row < height - 3; row++) {
                for (int col = 0; col < width - 3; col++) {
                    char color = board[row][col];
                    if (color != ' ' && color == board[row + 1][col + 1] && color == board[row + 2][col + 2] && color == board[row + 3][col + 3]) {
                        return color;
                    }
                }
            }

            return ' '; // No winner
        }

        public boolean isFull(int column) {
            if (column < 0 || column >= width) {
                throw new IllegalArgumentException("Column out of bounds");
            }
            return board[0][column] != ' '; // If the top row of the column is not empty, the column is full
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    sb.append(board[row][col]);
                    if (col < width - 1) sb.append("|");
                }
                sb.append("\n");
                if (row < height - 1) {
                    sb.append("-".repeat(width * 2 - 1)).append("\n");
                }
            }
            return sb.toString();
        }

}