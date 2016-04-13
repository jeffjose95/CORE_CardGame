package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.theGame;

public class BattleScreen implements Screen {
	
	Texture ActiveMonsterPosition;
	Texture BenchMonster1Position;
	Texture BenchMonster2Position;
	Texture BenchMonster3Position;
	Texture BenchMonster4Position;
	Texture BenchModifyer1Position;
	Texture BenchModifyer2Position;
	Texture BenchModifyer3Position;
	Texture ActiveMagicPosition;
	Texture ActiveMonsterMagic1Position;
	Texture ActiveMonsterMagic2Position;
	Texture ActiveMonsterMagic3Position;
	Texture DeckPosition;
	Texture GraveyardPosition;
	theGame game;
	
	Texture EnemyActiveMonsterPosition;
	Texture EnemyBenchMonster1Position;
	Texture EnemyBenchMonster2Position;
	Texture EnemyBenchMonster3Position;
	Texture EnemyBenchMonster4Position;
	Texture EnemyBenchModifyer1Position;
	Texture EnemyBenchModifyer2Position;
	Texture EnemyBenchModifyer3Position;
	Texture EnemyActiveMagicPosition;
	Texture EnemyActiveMonsterMagic1Position;
	Texture EnemyActiveMonsterMagic2Position;
	Texture EnemyActiveMonsterMagic3Position;
	Texture EnemyDeckPosition;
	Texture EnemyGraveyardPosition;
	
	private Texture[] benched;
	private Texture[] modifyers;
	private ArrayList<Texture> Deck;
	
	public BattleScreen(theGame game) {
		
		//Deck = game.Deck.CardDeck();
		benched = new Texture[4];
		modifyers = new Texture[3];
		
		ActiveMonsterPosition = new Texture("CardBox.png");
		BenchMonster1Position = new Texture("CardBox.png");
		BenchMonster2Position = new Texture("CardBox.png");
		BenchMonster3Position = new Texture("CardBox.png");
		BenchMonster4Position = new Texture("CardBox.png");
		BenchModifyer1Position = new Texture("CardBox.png");
		BenchModifyer2Position = new Texture("CardBox.png");
	    BenchModifyer3Position = new Texture("CardBox.png");
	    
		DeckPosition = new Texture("CardBox.png");
		GraveyardPosition = new Texture("CardBox.png");

		
		
		this.game = game;
		EnemyActiveMonsterPosition = new Texture("CardBox.png");
		EnemyBenchMonster1Position = new Texture("CardBox.png");
		EnemyBenchMonster2Position = new Texture("CardBox.png");
		EnemyBenchMonster3Position = new Texture("CardBox.png");
		EnemyBenchMonster4Position = new Texture("CardBox.png");
		EnemyBenchModifyer1Position = new Texture("CardBox.png");
		EnemyBenchModifyer2Position = new Texture("CardBox.png");
		EnemyBenchModifyer3Position = new Texture("CardBox.png");
		EnemyDeckPosition = new Texture("CardBox.png");
		EnemyGraveyardPosition = new Texture("CardBox.png");
		
		benched[0] = BenchMonster1Position;
		benched[1] = BenchMonster2Position;
		benched[2] = BenchMonster3Position;
		benched[3] = BenchMonster4Position;

		modifyers[0] = BenchModifyer1Position;
		modifyers[1] = BenchModifyer2Position;
		modifyers[2] = BenchModifyer3Position;

	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(ActiveMonsterPosition,275,150,50,50);
		game.batch.draw(BenchMonster1Position,200,75,50,50);
		game.batch.draw(BenchMonster2Position,250,75,50,50);
		game.batch.draw(BenchMonster3Position,300,75,50,50);
		game.batch.draw(BenchMonster4Position,350,75,50,50);
		game.batch.draw(BenchModifyer1Position,50,150,50,50);
		game.batch.draw(BenchModifyer2Position,50,100,50,50);
		game.batch.draw(BenchModifyer3Position,50,50,50,50);
		game.batch.draw(DeckPosition,500,75,50,50);
		game.batch.draw(GraveyardPosition,500,125,50,50);
		
		game.batch.draw(EnemyActiveMonsterPosition,275,300,50,50);
		game.batch.draw(EnemyBenchMonster1Position,350,400,50,50);
		game.batch.draw(EnemyBenchMonster2Position,300,400,50,50);
		game.batch.draw(EnemyBenchMonster3Position,250,400,50,50);
		game.batch.draw(EnemyBenchMonster4Position,200,400,50,50);
		game.batch.draw(EnemyBenchModifyer1Position,500,300,50,50);
		game.batch.draw(EnemyBenchModifyer2Position,500,350,50,50);
		game.batch.draw(EnemyBenchModifyer3Position,500,400,50,50);
		game.batch.draw(EnemyDeckPosition,50,400,50,50);
		game.batch.draw(EnemyGraveyardPosition,50,350,50,50);
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
