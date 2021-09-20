import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameLogicChecker {
    WinnerChecker winnerChecker;
    @Test
    public void test0Winner1() {
        Tile[][] board = new Tile[3][3];
        board[0][0].text.setText("0");
        board[1][0].text.setText("0");
        board[2][0].text.setText("0");
        board[0][1].text.setText("0");
        board[1][1].text.setText("0");
        board[2][1].text.setText("0");
        board[0][2].text.setText("0");
        board[1][2].text.setText("0");
        board[2][2].text.setText("0");
        assertEquals(true, Check0Complete.isComplete0(board) );
    }
    @Test
    public void test0Winner2() {
        TicTacToeApp.board[1][1].text.setText("0");
        TicTacToeApp.board[1][1].text.setText("0");
        TicTacToeApp.board[1][2].text.setText("0");
        assertEquals(false, Check0Complete.isComplete0(TicTacToeApp.board) );
    }
    @Test
    public void testXWinner1() {
        TicTacToeApp.board[1][1].text.setText("X");
        TicTacToeApp.board[1][1].text.setText("X");
        TicTacToeApp.board[1][2].text.setText("X");
        assertEquals(false, CheckXComplete.isCompleteX(TicTacToeApp.board) );
    }
    @Test
    public void testXWinner2() {
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
        assertEquals(true, CheckXComplete.isCompleteX(board) );
    }




}