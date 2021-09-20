import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ThemeUpdate{

    public static Text text = new Text();

    public static ImageView imageView = new ImageView();

    public static void update_Theme(){
        switch(TicTacToeApp.theme){
            case CLASSIC:
                text.setOpacity(1);
                imageView.setOpacity(0);

                break;
            case FORREST:
                text.setOpacity(0);
                imageView.setOpacity(1);
                if(text.getText().equals("X")){
                    imageView.setImage(new Image(ThemeUpdate.class.getResource("flower.png").toString()));
                }else if(text.getText().equals("O")){
                    imageView.setImage(new Image(ThemeUpdate.class.getResource("apple.png").toString()));
                }
                break;
            case HIGH_CONTRAST:
                text.setOpacity(0);
                imageView.setOpacity(1);
                if(text.getText().equals("X")){
                    imageView.setImage(new Image(ThemeUpdate.class.getResource("human.png").toString()));
                }else if(text.getText().equals("O")){
                    imageView.setImage(new Image(ThemeUpdate.class.getResource("ai.png").toString()));
                }
                break;
        }
    }
}
