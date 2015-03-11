package com.mygdx.eternity.screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.eternity.tween.ActorAaccessor;

public class MainMenu implements Screen {
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonExit, buttonPlay;
	private Label heading; 
	private TweenManager tweenManager;
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		tweenManager.update(delta);
		stage.act(delta);
		stage.draw();
	}
	
	@Override			
	public void show() {
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("gui/button.pack");
		skin = new Skin(Gdx.files.internal("gui/MenuSkin.json"), atlas);
		
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		// creating fonts 
		
		
		// create heading
		
		heading = new Label("Main Menu", skin);
		heading.setFontScale(1);
		

		
		// create buttons
		
		buttonPlay = new TextButton("Play", skin);
		buttonPlay.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new Levels());
			}
		});	
		buttonPlay.pad(18);
		
		buttonExit = new TextButton("EXIT", skin);
		buttonExit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		buttonExit.pad(15);
		
		
		// putting stuff together
		table.add(heading);
		table.getCell(heading).spaceBottom(100);
		table.row();
		table.add(buttonPlay);
		table.getCell(buttonPlay).spaceBottom(20);
		table.row();
		table.add(buttonExit);
		//table.debug(); 
		stage.addActor(table);
		
		// create animation
		
		tweenManager = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAaccessor());
		
		// heading color animation
		Timeline.createSequence().beginSequence()
			.push(Tween.to(heading, ActorAaccessor.RGB, .5f).target(0, 0, 1))
			.push(Tween.to(heading, ActorAaccessor.RGB, .5f).target(0, 1, 0))
			.push(Tween.to(heading, ActorAaccessor.RGB, .5f).target(1, 0, 0))
			.push(Tween.to(heading, ActorAaccessor.RGB, .5f).target(1, 1, 0))
			.push(Tween.to(heading, ActorAaccessor.RGB, .5f).target(0, 1, 1))
			.push(Tween.to(heading, ActorAaccessor.RGB, .5f).target(1, 1, 1))
			.end().repeat(Tween.INFINITY, 0).start(tweenManager);
		
		//heading and buttons fade-in
		Timeline.createSequence().beginSequence()
			.push(Tween.set(buttonPlay, ActorAaccessor.ALPHA).target(0))
			.push(Tween.set(buttonExit, ActorAaccessor.ALPHA).target(0))
			.push(Tween.from(heading, ActorAaccessor.ALPHA, .25f).target(0))
			.push(Tween.to(buttonPlay, ActorAaccessor.ALPHA, .25f).target(1))
			.push(Tween.to(buttonExit, ActorAaccessor.ALPHA, .25f).target(1))
			.end().start(tweenManager);
		
		// heading and button fade-in
		Tween.from(table, ActorAaccessor.ALPHA, .5f).target(0);
		Tween.from(table, ActorAaccessor.Y, .5f).target(Gdx.graphics.getHeight() / 8).start(tweenManager);
		
	}


	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
		table.setFillParent(true);
		
		
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
		stage.dispose();
		atlas.dispose();
		skin.dispose();

	}

}
