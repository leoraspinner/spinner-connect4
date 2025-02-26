package spinner.connect4;

public class ConnectBoard
{



    private int width;
    private int height;
    private char[][] board;



    public ConnectBoard(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.board = new char[height][width];
    }

    public void Insert (int column, char color){
        for (int row = height - 1; row >= 0; row--) {
            if (board[row][column] == 0) {
                board[row][column] = color;
                return;
            }
        }
    }

    public char CalculateWinner() {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                char color = board[r][c];
                if (color != 0) {
                    if (checkWin(r, c, 0, 1) || checkWin(r, c, 1, 0) ||
                            checkWin(r, c, 1, 1) || checkWin(r, c, 1, -1)) {
                        return color;
                    }
                }
            }
        }
        return 0;
    }

    private boolean checkWin(int r, int c, int dr, int dc) {
        char color = board[r][c];
        for (int i = 1; i < 4; i++) {
            int nr = r + i * dr, nc = c + i * dc;
            if (nr < 0 || nr >= height || nc < 0 || nc >= width || board[nr][nc] != color) {
                return false;
            }
        }
        return true;
    }

    public boolean IsFull(int column) {
        return board[0][column] != 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) { // Changed to iterate over height
            sb.append('|');
            for (int j = 0; j < width; j++) { // Changed to iterate over width
                sb.append(board[i][j] == 0 ? ' ' : board[i][j]).append('|');
            }
            sb.append('\n');
        }
        sb.append("-".repeat(2 * width + 1)).append('\n');
        return sb.toString();
    }
}