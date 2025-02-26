import org.junit.jupiter.api.Test;
import spinner.connect4.ConnectBoard;
import static org.junit.jupiter.api.Assertions.*;

class ConnectBoardTest {

    @Test
    void testInsert() {
        ConnectBoard board = new ConnectBoard(7, 6);
        board.insert(3, 'R');
        board.insert(3, 'Y');
        for (int i = 0; i < 6; i++) { board.insert(0, 'R');
    }

    @Test
    void testCalculateWinner() {
            ConnectBoard board = new ConnectBoard(7, 6);
        }
            assertEquals(0, board.calculateWinner());

            // Horizontal win
            for (int i = 0; i < 4; i++) {
                board.insert(i, 'R');
            }
            assertEquals('R', board.calculateWinner());

            // Vertical win
            board = new ConnectBoard(7, 6);
            for (int i = 0; i < 4; i++) {
                board.insert(0, 'Y');
            }
            assertEquals('Y', board.calculateWinner());

            // Diagonal win
            board = new ConnectBoard(7, 6);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < i; j++) {
                    board.insert(i, 'Y');
                }
                board.insert(i, 'R');
            }
            assertEquals('R', board.calculateWinner());
        }

        @Test
        void testIsFull() {
            ConnectBoard board = new ConnectBoard(7, 6);
            assertFalse(board.isFull(0));
            for (int i = 0; i < 6; i++) {
                board.insert(0, 'R');
            }
            assertTrue(board.isFull(0));
            assertFalse(board.isFull(1));
        }

        @Test
        void testToString() {
            ConnectBoard board = new ConnectBoard(3, 2);
            board.insert(0, 'R');
            board.insert(1, 'Y');
            board.insert(1, 'R');
            String expected = "| |R| |\n|R|Y| |\n-------\n";
            assertEquals(expected, board.toString());
        }
    }