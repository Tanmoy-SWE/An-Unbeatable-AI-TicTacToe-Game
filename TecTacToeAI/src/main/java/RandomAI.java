public class RandomAI extends AI{
    @Override
    //Generating moves from random number
    public void generateMove(Tile[][] board) {
        //It is obvious that every digit will come at least once within 5000 iterations
        int count=5000;
        while(count!=0){
            int max = 8;
            int min = 0;
            int random = (int)(Math.random()*(max-min+1)+min);
            int rows = random/3;
            int cols = random%3;
            if (board[rows][cols].text.getText() == "") {
                board[rows][cols].draw0();
                break;
            }
            count--;
        }
    }
}
