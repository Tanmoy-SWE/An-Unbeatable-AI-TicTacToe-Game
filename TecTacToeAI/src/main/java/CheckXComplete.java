public class CheckXComplete {
    public static  boolean isCompleteX(Tile[][] board) {
        if(board[0][0].text.getText().equals("X") && board[0][1].text.getText().equals("X") && board[0][2].text.getText().equals("X")) return true;
        if(board[1][0].text.getText().equals("X") && board[1][1].text.getText().equals("X") && board[1][2].text.getText().equals("X")) return true;
        if(board[2][0].text.getText().equals("X") && board[2][1].text.getText().equals("X") && board[2][2].text.getText().equals("X")) return true;

        if(board[0][0].text.getText().equals("X") && board[1][0].text.getText().equals("X") && board[2][0].text.getText().equals("X")) return true;
        if(board[0][1].text.getText().equals("X") && board[1][1].text.getText().equals("X") && board[2][1].text.getText().equals("X")) return true;
        if(board[0][2].text.getText().equals("X") && board[1][2].text.getText().equals("X") && board[2][2].text.getText().equals("X")) return true;

        if(board[0][0].text.getText().equals("X") && board[1][1].text.getText().equals("X") && board[2][2].text.getText().equals("X")) return true;
        if(board[0][2].text.getText().equals("X") && board[1][1].text.getText().equals("X") && board[2][0].text.getText().equals("X")) return true;

        return false;
    }
}
