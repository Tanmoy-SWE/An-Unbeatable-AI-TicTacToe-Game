import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class HighContrastTheme {
    public static void HighContrastHumanOnBoard(Text text, ImageView imageView){
        text.setOpacity(0);
        text.setText("X");
        imageView.setOpacity(1);
        imageView.setDisable(false);
        imageView.setImage(new Image(HighContrastTheme.class.getResource("Black.png").toString()));
    }
    public static void HighContrastAIOnBoard(Text text, ImageView imageView){
        text.setText("O");
        imageView.setOpacity(1);
        imageView.setDisable(false);
        imageView.setImage(new Image(HighContrastTheme.class.getResource("White.png").toString()));
    }
}
