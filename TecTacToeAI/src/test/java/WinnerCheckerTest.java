import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WinnerCheckerTest {
    @Test
    public void testWinnerX() {
        Tile[][] board = new Tile[3][3];
        board[0][0].text.setText("X");
        board[1][0].text.setText("X");
        board[2][0].text.setText("X");
        board[0][1].text.setText("0");
        board[1][1].text.setText("X");
        board[2][1].text.setText("X");
        board[0][2].text.setText("X");
        board[1][2].text.setText("0");
        board[2][2].text.setText("0");
        assertEquals(-1, WinnerChecker.checkWinner() );
    }



}