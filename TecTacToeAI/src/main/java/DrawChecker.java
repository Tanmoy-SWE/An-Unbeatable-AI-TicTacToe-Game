public class DrawChecker {
    public static boolean isDraw(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(TicTacToeApp.board[i][j].text.getText().isEmpty()) return false;
            }
        }
        return true;
    }
}
