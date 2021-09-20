import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class TicTacToeApp extends Application {

    public static boolean isBlank = true;
    public static boolean isX = false;
    public static Tile previous_move;

    public static boolean defensive_AI = false;

    Line line1, line2, line3, line4;

    public enum Themes{
        CLASSIC,
        FORREST,
        HIGH_CONTRAST
    }

    public static Themes theme = Themes.CLASSIC;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("The TIC-TAC-TOE Game!");
        primaryStage.setScene(new Scene(createBoard()));
        classic_theme();
        primaryStage.show();
    }

    public Pane root = new Pane();

    public static Tile[][] board = new Tile[3][3];

    private void left_side() {
        VBox box = new VBox();
        box.setStyle("-fx-background-color: white;");
        box.setSpacing(10);
        box.setAlignment(Pos.TOP_LEFT);
        box.setLayoutX(3* 200);
        box.setLayoutY(0);
        box.setPrefSize(300, 600);
        box.setPadding(new Insets(20));
        box.getChildren().add(getLabel("Theme", Font.font("Aril", FontWeight.EXTRA_BOLD, 30), Color.BLACK));
        RadioButton classic_rb = getRadioButton("Classic", Font.font("Arial", FontPosture.REGULAR, 26),
                theme == Themes.CLASSIC);
        RadioButton forrest_rb = getRadioButton("Forrest", Font.font("Arial", FontPosture.REGULAR, 26),
                theme == Themes.FORREST);
        RadioButton highContrast_rb = getRadioButton("High Contrast", Font.font("Arial", FontPosture.REGULAR, 26),
                theme == Themes.HIGH_CONTRAST);

        box.getChildren().addAll(classic_rb, forrest_rb, highContrast_rb);
        group_radioButtons(classic_rb, forrest_rb, highContrast_rb);

        VBox bottom_btns = new VBox();
        bottom_btns.setSpacing(20);
        bottom_btns.setAlignment(Pos.BOTTOM_LEFT);

        String style = """
                -fx-background-color: white;
                -fx-text-fill: black;
                -fx-border-radius: 10;
                -fx-background-radius: 10;
                -fx-pref-width: 300;
                -fx-pref-height: 45;
                -fx-border-color: #6b6b6b;
                """;
        String style_hover = """
                -fx-background-color: black;
                -fx-text-fill: white;
                -fx-border-radius: 10;
                -fx-background-radius: 10;
                -fx-pref-width: 300;
                -fx-pref-height: 45;
                -fx-border-color: #6b6b6b;
                """;


        bottom_btns.getChildren().add(get_button("Start With Random AI", Font.font("Arial", FontPosture.REGULAR, 20), e->{
            // Here you can do stuff of Random AI
            defensive_AI = false;
        }, style, style_hover));
        bottom_btns.getChildren().add(get_button("Start With Defensive AI", Font.font("Arial", FontPosture.REGULAR, 20), e->{
            // Here you can do stuff of defensive AI.
            defensive_AI = true;
        }, style, style_hover));

        bottom_btns.getChildren().add(get_button("Start New Game", Font.font("Arial", FontPosture.REGULAR, 20), e->{
            isBlank = true;
            for(int i = 0; i<3 ; i++){
                for(int j = 0; j< 3; j++){
                    board[i][j].text.setText("");
                    board[i][j].imageView.setImage(null);
                }
            }
            isX = false;
            previous_move = null;
        }, style, style_hover));
        box.getChildren().add(bottom_btns);
        bottom_btns.setPrefHeight(400);

        root.getChildren().add(box);
    }

    void classic_theme(){
        root.setStyle("-fx-background-color: white");
        lines_color(Color.BLACK);
    }
    void lines_color(Color color){
        line1.setStroke(color);
        line2.setStroke(color);
        line3.setStroke(color);
        line4.setStroke(color);
    }

    void forest_theme(){
        root.setStyle("-fx-background-color: lightgreen;");
        lines_color(Color.DARKGREEN);
    }
    void high_contrast_theme(){
        root.setStyle("-fx-background-color: #414345");
        lines_color(Color.LIGHTGRAY);
    }

    public Parent createBoard() {
        root.setPrefSize(900, 600);
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                Tile tile = new Tile(board);
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);
                root.getChildren().add(tile);
                board[j][i] = tile;
            }
        }

        line1 = getLine(200, 15, 200, 600-15,
                theme == Themes.CLASSIC ? Color.BLACK :
                        theme == Themes.FORREST ? Color.YELLOW :
                                Color.WHITE);

        line2 = getLine(400, 15, 400, 600-15, theme == Themes.CLASSIC ? Color.BLACK :
                theme == Themes.FORREST ? Color.YELLOW :
                        Color.WHITE);
        line3 = getLine(15, 200, 600-15, 200, theme == Themes.CLASSIC ? Color.BLACK :
                theme == Themes.FORREST ? Color.YELLOW :
                        Color.WHITE);
        line4 = getLine(15, 400, 600-15, 400, theme == Themes.CLASSIC ? Color.BLACK :
                theme == Themes.FORREST ? Color.YELLOW :
                        Color.WHITE);

        root.getChildren().addAll(line1,line2,line3,line4);
        left_side();
        return root;
    }

    Label getLabel(String text, Font font, Color color){
        Label label = new Label();
        label.setText(text);
        label.setFont(font);
        label.setTextFill(color);
        return label;
    }

    RadioButton getRadioButton(String text, Font font, boolean isSelected){
        RadioButton radioButton = new RadioButton(text);
        radioButton.setFont(font);
        radioButton.setSelected(isSelected);
        return radioButton;
    }

    Button get_button(String str, Font font, EventHandler<ActionEvent> event, String s, String hover){
        Button btn = new Button(str);
        btn.setFont(font);
        btn.setOnAction(event);
        btn.setStyle(s);

        btn.hoverProperty().addListener((observableValue, aBoolean, t1) -> {
            if(t1){
                btn.setStyle(hover);
            }else btn.setStyle(s);
        });
        return btn;
    }

    void update_theme(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j].update_theme();
            }
        }
    }

    void group_radioButtons(RadioButton... btns){
        for (RadioButton btn : btns) {
            btn.selectedProperty().addListener((observable , oldValue, newValue ) ->{
                if(newValue){
                    switch(btn.getText()){
                        case "Classic":
                            theme = Themes.CLASSIC;
                            classic_theme();
                            break;
                        case "Forrest":
                            theme = Themes.FORREST;
                            forest_theme();
                            break;
                        case "High Contrast":
                            theme = Themes.HIGH_CONTRAST;
                            high_contrast_theme();
                            break;
                    }
                    update_theme();

                    for (RadioButton radioButton : btns) {
                        if(btn == radioButton) continue;
                        radioButton.setSelected(false);
                    }
                }
            });
        }
    }

    Line getLine(double startX, double startY, double endX, double endY, Color color){
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.setStroke(color);
        line.setStrokeWidth(6);
        return line;
    }

    public static void dialog_msg(String title, String head, String msg){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(head);
        dialog.setContentText(msg);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

}