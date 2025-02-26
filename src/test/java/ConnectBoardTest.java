import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spinner.connect4.ConnectBoard;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectBoardTest {

    private ConnectBoard board;

    @BeforeEach
    public void setUp() {
        board = new ConnectBoard(7, 6); // Create a board of width 7 and height 6
    }

    @Test
    void testInsert() {
        ConnectBoard board = new ConnectBoard(7, 6);
        board.insert(3, 'R');
        board.insert(3, 'Y');
        for (int i = 0; i < 6; i++) {
            board.insert(0, 'R');
        }
    }

    @Test
    public void testIsFull() {
        // Initially, the column should not be full
        assertFalse(board.isFull(0));

        // Fill the column
        for (int i = 0; i < 6; i++) {
            board.insert(0, 'R');
        }

        // Now the column should be full
        assertTrue(board.isFull(0));
    }

    @Test
    public void testCalculateWinner() {
        // Test horizontal win
        board.insert(0, 'R');
        board.insert(1, 'R');
        board.insert(2, 'R');
        board.insert(3, 'R');
        assertEquals('R', board.calculateWinner()); // Should return 'R'

        // Reset the board
        board = new ConnectBoard(7, 6);

        // Test vertical win
        for (int i = 0; i < 4; i++) {
            board.insert(0, 'Y');
        }
        assertEquals('Y', board.calculateWinner()); // Should return 'Y'

        // Reset the board
        board = new ConnectBoard(7, 6);

        // Test diagonal win (bottom-left to top-right)
        board.insert(0, 'R');
        board.insert(1, 'Y');
        board.insert(1, 'R');
        board.insert(2, 'Y');
        board.insert(2, 'Y');
        board.insert(2, 'R');
        board.insert(3, 'Y');
        board.insert(3, 'Y');
        board.insert(3, 'Y');
        board.insert(3, 'R');
        assertEquals('R', board.calculateWinner()); // Should return 'R'

        // Reset the board
        board = new ConnectBoard(7, 6);

        // Test diagonal win (top-left to bottom-right)
        board.insert(3, 'Y');
        board.insert(2, 'Y');
        board.insert(1, 'Y');
        board.insert(0, 'Y');
        assertEquals('Y', board.calculateWinner()); // Should return 'Y'
    }
}
