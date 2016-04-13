package screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.theGame;

public class GameScreen implements Screen {
	float screenHeight = Gdx.graphics.getHeight();
	float screenWidth = Gdx.graphics.getWidth();

	private final theGame game;
	Texture newGameButtonActive;
	Texture newGameButtonInactive;
	Texture DeckEditButtonActive;
	Texture DeckEditButtonInactive;
	
	

	public GameScreen(theGame game)
	{
		this.game = game;
		newGameButtonActive = new Texture("new game2.png");
		newGameButtonInactive = new Texture("new game1.png");
		DeckEditButtonActive = new Texture("Deck2.png");
		DeckEditButtonInactive = new Texture("Deck1.png");
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		float DeckX = screenWidth/2-50;
		float DeckY = screenHeight/2 - 50;
	
		if(Gdx.input.getX()<DeckX+100 && Gdx.input.getX()>DeckX && Gdx.input.getY()<DeckY - 50 && Gdx.input.getY()>DeckY - 150)
		{
		game.batch.draw(DeckEditButtonActive, (screenWidth/2) - 50,(screenHeight/2)+100, 100, 100);
		
		if(Gdx.input.justTouched())
		{
			game.setScreen(game.Deck);
		
		}
		}
		else
		{
			game.batch.draw(DeckEditButtonInactive, (screenWidth/2) - 50,(screenHeight/2)+100, 100, 100);
			
		}
		
		
		
		if(Gdx.input.getX()<DeckX+100 && Gdx.input.getX()>DeckX && Gdx.input.getY()<DeckY + 150 && Gdx.input.getY()>DeckY + 50)
		{
			game.batch.draw(newGameButtonActive, (screenWidth/2) - 50, (screenHeight/2)-100, 100, 100);
			
			if(Gdx.input.justTouched())
			{
				game.setScreen(game.Battle);
				
			}
		}
		else
		{
			game.batch.draw(newGameButtonInactive, (screenWidth/2) - 50, (screenHeight/2)-100, 100, 100);
			
		}
		game.batch.end();
	}

	

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
		
	}

}
