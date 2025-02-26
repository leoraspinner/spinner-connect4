package spinner.connect4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spinner.connect4.ConnectBoard;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectBoardTest
{

    private ConnectBoard board;

    @BeforeEach
    public void setUp()
    {
        board = new ConnectBoard(7, 6); // Create a board of width 7 and height 6
    }

    @Test
    void testInsert()
    {
        ConnectBoard board = new ConnectBoard(7, 6);
        board.insert(3, 'R');
        board.insert(3, 'Y');
        for (int i = 0; i < 6; i++) {
            board.insert(0, 'R');
        }
    }

    @Test
    public void testIsFull()
    {
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
    public void testCalculateWinnerHorizontal() {
        ConnectBoard board = new ConnectBoard(7, 6);

        // Create a horizontal win for 'X'
        board.insert(0, 'X');
        board.insert(1, 'X');
        board.insert(2, 'X');
        board.insert(3, 'X');

        // Assert that 'X' is the winner
        assertEquals('X', board.calculateWinner(), "Expected 'X' to be the winner for horizontal alignment");
    }
}

