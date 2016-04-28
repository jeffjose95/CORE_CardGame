package Helper;

import com.badlogic.gdx.Gdx;

import board.Player;

public class GameWorld {

	private Player human;
	private Player AI;
	public GameWorld()
	{
		
	}
	 public void update(float delta) {
	        Gdx.app.log("GameWorld", "update");
	    }
	 public Player getPlayer()
	 {
		 return human;
	 }
}
