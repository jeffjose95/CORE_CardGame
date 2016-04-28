package Helper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

    public static Texture bg;
    public static Texture GameField;
  
//    public static Animation cardAnimation;
 //   public static Texture card, cardDown, cardUp;


    public static void load() {

        bg = new Texture("Background.png");
        GameField = new Texture("GameField.png");
    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        bg.dispose();
        GameField.dispose();
    }

}