import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Tile extends StackPane {
    public Text text = new Text();

    public AI ai = new RandomAI();
    public AI defensive_ai = new MoveGenerator();

    public ImageView imageView = new ImageView();


    public Tile[][] board;

    public Tile(Tile[][] board) {
        this.board = board;
        Rectangle border = new Rectangle(200, 200);
        border.setFill(null);
        text.setFont(Font.font(100));
        setAlignment(Pos.CENTER);

        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        getChildren().addAll(border, text, imageView); // added text as list of children

        //Click Action as "X" & "0" as its object oriented
        setOnMouseClicked(event -> {
            if (!TicTacToeApp.isBlank)
                return;
            if (event.getButton() == MouseButton.PRIMARY) {
                drawX();

                if(DrawChecker.isDraw()){
                    TicTacToeApp.isBlank = false;
                    TicTacToeApp.dialog_msg("Game Over","Draw","No Body Won the match");
                }
                if(CheckXComplete.isCompleteX(board)){
                    System.out.println("X has won");
                    TicTacToeApp.isBlank = false;
                    TicTacToeApp.isX = true;
                    TicTacToeApp.dialog_msg("Game Over","Winner","Human has victory against AI");
                }

                if(!TicTacToeApp.isBlank)
                    return;
                if(TicTacToeApp.defensive_AI)
                    defensive_ai.generateMove(board);
                else
                    ai.generateMove(board);

                if(Check0Complete.isComplete0(board)){
                    System.out.println("O has won");
                    TicTacToeApp.isBlank = false;
                    TicTacToeApp.isX = false;
                    TicTacToeApp.dialog_msg("Game Over","Winner","AI has victory against Human");
                }
            }
        });
    }
    public void update_theme(){
        ThemeUpdate.update_Theme();
    }

    //Initializing the "X" & "0" as text
    private void drawX(){
        switch (TicTacToeApp.theme) {
            case CLASSIC:
                ClassicTheme.ClassicXOnBoard(text,imageView);
                break;
            case FORREST:
                ForestTheme.ForestHumanOnBoard(text, imageView);
                break;
            case HIGH_CONTRAST:
                HighContrastTheme.HighContrastHumanOnBoard(text, imageView);
                break;
        }
    }

    public void draw0(){
        switch (TicTacToeApp.theme) {
            case CLASSIC:
                ClassicTheme.Classic0OnBoard(text, imageView);
                break;
            case FORREST:
                ForestTheme.ForestAIOnBoard(text, imageView);
                break;
            case HIGH_CONTRAST:
                HighContrastTheme.HighContrastAIOnBoard(text, imageView);
                break;
        }
    }




}