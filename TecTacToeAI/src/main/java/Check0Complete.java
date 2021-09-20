public class Check0Complete  {

    public static boolean isComplete0(Tile[][] board) {
        if(board[0][0].text.getText().equals("O") && board[0][1].text.getText().equals("O") && board[0][2].text.getText().equals("O")) return true;
        if(board[1][0].text.getText().equals("O") && board[1][1].text.getText().equals("O") && board[1][2].text.getText().equals("O")) return true;
        if(board[2][0].text.getText().equals("O") && board[2][1].text.getText().equals("O") && board[2][2].text.getText().equals("O")) return true;

        if(board[0][0].text.getText().equals("O") && board[1][0].text.getText().equals("O") && board[2][0].text.getText().equals("O")) return true;
        if(board[0][1].text.getText().equals("O") && board[1][1].text.getText().equals("O") && board[2][1].text.getText().equals("O")) return true;
        if(board[0][2].text.getText().equals("O") && board[1][2].text.getText().equals("O") && board[2][2].text.getText().equals("O")) return true;

        if(board[0][0].text.getText().equals("O") && board[1][1].text.getText().equals("O") && board[2][2].text.getText().equals("O")) return true;
        if(board[0][2].text.getText().equals("O") && board[1][1].text.getText().equals("O") && board[2][0].text.getText().equals("O")) return true;

        return false;
    }
}
