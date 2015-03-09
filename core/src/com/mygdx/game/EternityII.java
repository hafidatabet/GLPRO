package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.eternity.screens.Splash;

public class EternityII extends Game {
	SpriteBatch batch;
	// Texture img;
	public final static String TITLE = "Eternity II", VERSION = "0.0.0.0.reallyEarly";
	
	@Override
	public void create () {
		setScreen(new Splash());
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void resize (int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause () {
		super.pause();
	}

	@Override
	public void resume () {
		super.resume();
	}
	
}
