package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.GameScreen;

import screens.GameScreen;
import screens.BattleScreen;
import screens.DeckScreen;

public class theGame extends Game {
	public SpriteBatch batch;
	public GameScreen Start;
	public BattleScreen Battle;
	public DeckScreen Deck;

	
	@Override
	public void create () {
		Start = new GameScreen(this);
		Battle = new BattleScreen(this);
		Deck = new DeckScreen(this);
		batch = new SpriteBatch();
		this.setScreen(Start);
	}
}
