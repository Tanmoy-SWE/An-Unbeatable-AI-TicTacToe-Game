public abstract class DefensiveAI extends AI{

    public abstract void generateMove(Tile[][] board);
    public abstract int minimax(Tile[][] board, int depth, boolean isMaximizing);

}