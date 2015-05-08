package com.mygdx.eternity.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.AddListenerAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Selection;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.Select;

public class Tutorial implements Screen {
	
	private Stage stage;
	private Table table;
	private TextureAtlas atlas;
	private Skin skin, skin_deff;
	private TextButton back;
	private Label heading;
	private List<String> list;
	private ScrollPane scrollPane, scrollLabel;
	private Window window;

	@Override
	public void show() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("gui/atlas.pack");
		skin = new Skin(Gdx.files.internal("gui/MenuSkin.json"), atlas);
		skin_deff = new Skin(Gdx.files.internal("gui/uiskin.json"));
		
		table = new Table(skin);
		table.setFillParent(true);
		
		heading = new Label("Tutorial", skin, "big");
		
		list = new List<String>(skin);
		list.setItems(new String[] { "How to Play", "Game Rules", "More Info"});
		scrollPane = new ScrollPane(list, skin);
		
		back = new TextButton("Back", skin, "small");
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		});
		back.pad(10);
			   	
		
		window = new Window("abra9 martazaor abrador", skin_deff);
		window.add("The puzzle's scope was to fill a large almost regular dodecagon\n with 209 irregularly shaped smaller polygon pieces of the same color.\n All the pieces were made from a combination of equilateral\n triangles and half-triangles, with each piece having\n the same total area of 6 of those triangles,\n and between seven and eleven sides.");
		window.pack();
		
		// putting  stuff together
		
				// table.debug();
				
				table.add(heading).colspan(3).expandX().spaceBottom(50).row();
				table.add(scrollPane).uniformX().expandY().top().left();
				table.add(window).top();
				// table.add(play).uniformX();
				table.add(back).uniformX().bottom().right();
				stage.addActor(table);
				
				list.addListener(new ChangeListener() {
					
					@Override
					public void changed(ChangeEvent event, Actor actor) {
						switch (list.getSelectedIndex()) {
						case 0:
							table.clear();
							window = new Window("3asboura bel zabbour", skin_deff);
							window.add("The puzzle's scope was to fill a large almost regular dodecagon\n with 209 irregularly shaped smaller polygon pieces of the same color.\n All the pieces were made from a combination of equilateral\n triangles and half-triangles, with each piece having\n the same total area of 6 of those triangles,\n and between seven and eleven sides.");
							window.pack();							
							table.add(heading).colspan(3).expandX().spaceBottom(50).row();
							table.add(scrollPane).uniformX().expandY().top().left();
							table.add(window).top();
							// table.add(play).uniformX();
							table.add(back).uniformX().bottom().right();
							stage.addActor(table);
							break;
						case 1: 
							table.clear();
							window = new Window("hazbar bazbar nazbar", skin_deff);
							window.add("The puzzle's scope was to fill a large almost regular dodecagon\n with 209 irregularly shaped smaller polygon pieces of the same color.\n All the pieces were made from a combination of equilateral\n triangles and half-triangles, with each piece having\n the same total area of 6 of those triangles,\n and between seven and eleven sides.");
							window.pack();							
							table.add(heading).colspan(3).expandX().spaceBottom(50).row();
							table.add(scrollPane).uniformX().expandY().top().left();
							table.add(window).top();
							// table.add(play).uniformX();
							table.add(back).uniformX().bottom().right();
							stage.addActor(table);	
						break;
						case 2:
							table.clear();
							window = new Window("abra9 martazaor abrador", skin_deff);
							window.add("The puzzle's scope was to fill a large almost regular dodecagon\n with 209 irregularly shaped smaller polygon pieces of the same color.\n All the pieces were made from a combination of equilateral\n triangles and half-triangles, with each piece having\n the same total area of 6 of those triangles,\n and between seven and eleven sides.");
							window.pack();							
							table.add(heading).colspan(3).expandX().spaceBottom(50).row();
							table.add(scrollPane).uniformX().expandY().top().left();
							table.add(window).top();
							// table.add(play).uniformX();
							table.add(back).uniformX().bottom().right();
							stage.addActor(table);
							
						break;
						
						default:
							
							break;
						}
					}			
					
				});
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
		table.invalidateHierarchy();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		skin_deff.dispose();
	}

}
