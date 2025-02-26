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
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void insert(int column, char color)
    {
        if (column < 0 || column >= width) {
            System.out.println("Column is out of bounds");
            return;
        }
        if (isFull(column)) {
            System.out.println("Column is full");
            return;
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
            for (int col = 0; col < width; col++) {
                char color = board[col][row];
                if (color != ' ') {
                    // Horizontal check
                    if (col + 3 < width
                            && color == board[col + 1][row]
                            && color == board[col + 2][row]
                            && color == board[col + 3][row]) {
                        return color;
                    }
                    // Vertical check
                    if (row + 3 < height
                            && color == board[col][row + 1]
                            && color == board[col][row + 2]
                            && color == board[col][row + 3]) {
                        return color;
                    }
                    // Diagonal down-right check
                    if (col + 3 < width && row + 3 < height
                            && color == board[col + 1][row + 1]
                            && color == board[col + 2][row + 2]
                            && color == board[col + 3][row + 3]) {
                        return color;
                    }
                    // Diagonal up-right check
                    if (col + 3 < width && row - 3 >= 0
                            && color == board[col + 1][row - 1]
                            && color == board[col + 2][row - 2]
                            && color == board[col + 3][row - 3]) {
                        return color;
                    }
                }
            }
        }
        return ' '; // No winner
    }

    public boolean isFull(int column)
    {
        if (column < 0 || column >= width) {
            return false;
        }
        return board[0][column] != ' '; // If the top row of the column is not empty, the column is full
    }


    @Override
    public String toString()
    {
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