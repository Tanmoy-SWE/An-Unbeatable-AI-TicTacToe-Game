import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ForestTheme {
    public static void ForestHumanOnBoard(Text text, ImageView imageView){
        text.setOpacity(0);
        text.setText("X");
        imageView.setOpacity(1);
        imageView.setImage(new Image(ForestTheme.class.getResource("flower.png").toString()));
        imageView.setDisable(false);
    }
    public static void ForestAIOnBoard(Text text, ImageView imageView){
        text.setText("O");
        imageView.setOpacity(1);
        imageView.setImage(new Image(ForestTheme.class.getResource("apple.png").toString()));
        imageView.setDisable(false);
    }
}
