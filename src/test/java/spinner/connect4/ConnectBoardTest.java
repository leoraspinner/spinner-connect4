package spinner.connect4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectBoardTest
{

    public void insert()
    {
        ConnectBoard board = new ConnectBoard(7, 6);
        board.insert(3, 'X');

        assertEquals('X', board.getBoard()[5][3]);
    }

    @Test
    public void isFull()
    {
        ConnectBoard board = new ConnectBoard(7, 6);
        assertFalse(board.isFull(0));

        // Fill the column 0
        for (int i = 0; i < 6; i++) {
            board.insert(0, 'R'); // Fill column 0 with 'R'
        }

        // Now the column should be full
        assertTrue(board.isFull(0));

        // Check an empty column (column 1)
        assertFalse(board.isFull(1));
    }

    @Test
    public void calculateWinner() {
        ConnectBoard board = new ConnectBoard(7, 6);

        board.insert(0, 'X');
        board.insert(1, 'X');
        board.insert(2, 'X');
        board.insert(3, 'X');

        // Assert that 'X' is the winner
        assertEquals('X', board.calculateWinner(), "Expected 'X' to be the winner");
    }
}

