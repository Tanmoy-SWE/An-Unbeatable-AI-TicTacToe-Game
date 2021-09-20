public class WinnerChecker {
    public static int checkWinner(){
        if(DrawChecker.isDraw()){
            return 0;
        }
        if(CheckXComplete.isCompleteX(TicTacToeApp.board)) {
            return 1;
        }
        else if(Check0Complete.isComplete0(TicTacToeApp.board)) {
            return -1;
        }
        else {
            return 2;
        }
    }
}
