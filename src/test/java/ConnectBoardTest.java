import org.junit.jupiter.api.Test;
import spinner.connect4.ConnectBoard;
import static org.junit.jupiter.api.Assertions.*;

class ConnectBoardTest {

    @Test
    void testInsert() {
        ConnectBoard board = new ConnectBoard(7, 6);
        board.Insert(3, 'R');
        board.Insert(3, 'Y');
        for (int i = 0; i < 6; i++) board.Insert(0, 'R');
    }

    @Test
    void testCalculateWinner() {
        ConnectBoard board = new ConnectBoard(7, 6);
        assertEquals(0, board.CalculateWinner());

        // Horizontal win
        for (int i = 0; i < 4; i++) board.Insert(i, 'R');
        assertEquals('R', board.CalculateWinner());

        // Vertical win
        board = new ConnectBoard(7, 6);
        for (int i = 0; i < 4; i++) board.Insert(0, 'Y');
        assertEquals('Y', board.CalculateWinner());

        // Diagonal win
        board = new ConnectBoard(7, 6);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) board.Insert(i, 'Y');
            board.Insert(i, 'R');
        }
        assertEquals('R', board.CalculateWinner());
    }

    @Test
    void testIsFull() {
        ConnectBoard board = new ConnectBoard(7, 6);
        assertFalse(board.IsFull(0));
        for (int i = 0; i < 6; i++) board.Insert(0, 'R');
        assertTrue(board.IsFull(0));
        assertFalse(board.IsFull(1));
    }

    @Test
    void testToString() {
        ConnectBoard board = new ConnectBoard(3, 2);
        board.Insert(0, 'R');
        board.Insert(1, 'Y');
        board.Insert(1, 'R');
        String expected = "| |R| |\n|R|Y| |\n-------\n";
        assertEquals(expected, board.toString());
    }
}
