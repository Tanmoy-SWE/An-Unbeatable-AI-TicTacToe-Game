import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ClassicTheme {

    public static void ClassicXOnBoard(Text text, ImageView imageView){
        text.setOpacity(1);
        text.setText("X");
        imageView.setOpacity(0);
        imageView.setDisable(true);
    }
    public static void Classic0OnBoard(Text text, ImageView imageView){
        text.setText("O");
        imageView.setOpacity(0);
        imageView.setDisable(true);
    }

}
