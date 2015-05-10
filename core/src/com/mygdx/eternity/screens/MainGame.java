package com.mygdx.eternity.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainGame implements Screen {
	
	private Stage stage;
	private Table table;
	private TextureAtlas atlas;
	private Skin skin;
	private List<String> list;
	private ScrollPane scrollPane;
	private TextButton back;
	private Label heading;
	ShapeRenderer renderer;
	PerspectiveCamera cam;
	SpriteBatch batch;
	BitmapFont font;
	
	
	@Override
	public void show() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		renderer = new ShapeRenderer();
		cam = new PerspectiveCamera(47, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(0, 0, 2);
		cam.near = 0.1f;
		batch = new SpriteBatch();
		
		atlas = new TextureAtlas("gui/atlas.pack");
		skin = new Skin(Gdx.files.internal("gui/MenuSkin.json"), atlas);
		
		table = new Table(skin);
		table.setFillParent(true);
		// table.debug();
		
		heading = new Label("Main Menue", skin, "big");
		
		list = new List<String>(skin);
		list.setItems(new String[] { "Start EternityII", "Tutorial", "Credit" });
		
		scrollPane = new ScrollPane(list, skin);
		
		
		
		back = new TextButton("Back", skin, "small");
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		});
		back.pad(10);
		
		// putting  stuff together
		table.add(heading).colspan(3).expandX().spaceBottom(50).row();;
		table.add(scrollPane).uniformX().expandY().top().left();
		// table.add(play).uniformX();
		table.add(back).uniformX().bottom().right();
		stage.addActor(table);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		cam.update();

		renderer.setProjectionMatrix(cam.combined);
		renderer.identity();
		renderer.rotate(0, 1, 0, 20);
		renderer.translate(-0.5f, -0.5f, 0);
		MathUtils.random.setSeed(0);
		

		renderer.end();

		if (Gdx.input.isKeyPressed(Keys.F)) {
			renderer.begin(ShapeType.Filled);

			renderer.setColor(Color.RED);
			renderer.rect(0, 0, 1, 1);

			

			renderer.end();
		} else {
			renderer.begin(ShapeType.Line);

			renderer.setColor(Color.RED);
			renderer.rect(0, 0, 1, 1);


			renderer.end();
		}

		batch.begin();
		
		stage.act(delta);
		stage.draw();
		batch.end();
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
		renderer.dispose();
		batch.dispose();
	}

	
	
}
