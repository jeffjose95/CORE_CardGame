package Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameRenderer {
	private GameWorld myWorld;
	private Texture CardBoxes;
	private Texture BackGround;
	
	  public GameRenderer(GameWorld world) {
		  myWorld = world;
		  BackGround = new Texture("Background.png");
		  CardBoxes = new Texture("GameField.png");
	}

	public void render(GameWorld world) {
	        Gdx.app.log("GameRenderer", "render");
	    }
}
