package com.mygdx.eternity.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MainGame implements Screen {
	
	private Stage stage;
	private Table table, matTable, sideTable, TabItems_one, TabItems_two, TabItems_tree ;
	private TextureAtlas atlas;
	private Skin skin;
	private List<Container> list;
	private ScrollPane scrollPane;
	private TextButton back;
	private Label heading;
	
	PerspectiveCamera cam;
	BitmapFont font;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void show() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		
		/*renderer = new ShapeRenderer();
		cam = new PerspectiveCamera(47, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(0, 0, 2);
		cam.near = 0.1f;
		batch = new SpriteBatch();*/
		
		atlas = new TextureAtlas("gui/atlas.pack");
		skin = new Skin(Gdx.files.internal("gui/MenuSkin.json"), atlas);
		
		TextureRegionDrawable logo = new TextureRegionDrawable(new TextureRegion(new Texture(
				Gdx.files.internal("csv/Capsqsqture.JPG"))));
		
		
		// main table
		table = new Table(skin);
		table.setFillParent(true);
		//table.debug();
		
		// matrix table
		matTable = new Table(skin);
		matTable.defaults().space(0).size(110);
		
		// side bar table
		sideTable = new Table(skin);
		
		// tab Items 1
		TabItems_one = new Table(skin);
		
		// tab Items 2
		TabItems_two = new Table(skin);
		
		// tab Items 3
		TabItems_tree = new Table(skin);
		
		// Inner Table
		Table innerContainer = new Table();
		innerContainer.defaults().spaceBottom(10).padLeft(25);
		
		
		heading = new Label("ETERNITY II", skin, "big");
		
		scrollPane = new ScrollPane(innerContainer, skin);
		
		
		
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
		
		// matrix display
		
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.row();
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.row();
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		matTable.row();
		matTable.add(new Container(label("")).background(logo));
		matTable.add(new Container(label("")).background(logo));
		
		Container transformBG = new Container(label("")).background(logo);
		transformBG.setTransform(true);
		transformBG.setOrigin(55, 55);
		transformBG.rotateBy(90);
		matTable.add(transformBG);

		Container transform = new Container(label("").background(logo));
		transform.setTransform(true);
		transform.setOrigin(55, 55);
		transform.rotateBy(90);
		matTable.add(transform);
		
		Container transform2 = new Container(label("").background(logo));
		transform.setTransform(true);
		transform.setOrigin(55, 55);
		transform.rotateBy(90);
		matTable.add(transform2);
		
		// side bar display 
		
		
		TabItems_one.add(new Image(logo)).expandY().fillY().size(110);
		
		TabItems_two.add(new Image(logo)).expandY().fillY().size(110);
		
		TabItems_tree.add(new Image(logo)).expandY().fillY().size(110);
		
		
		//inner table that is used as a makeshift list.
	    
	    innerContainer.add(TabItems_one).expand().fill();
	    innerContainer.row();
	    innerContainer.add(TabItems_two).expand().fill();
	    innerContainer.row();
	    innerContainer.add(TabItems_tree).expand().fill();
		
		
		// other window stuff
		table.add(matTable).top().spaceLeft(20);
		table.add(back).uniformX().bottom().right();
		stage.addActor(table);
		
		
	    // setup a listener for the tables with out data

	    TabItems_one.addListener(new FocusListener(){
	    	@Override
	        public boolean handle(Event event){

	        if (event.toString().equals("mouseMoved")){
	        	TabItems_one.background(new TextureRegionDrawable(new TextureRegion(new Texture("csv/Capsqsqture.JPG"))));
	            return false;
	        }
	        else if(event.toString().equals("exit")){
	            //table1.setBackground(null);
	            //table1.background("");
	        	//TabItems_one.setBackground(null);

	            return false;
	        }
	            return true;
	        }

	    });
	    TabItems_two.addListener(new FocusListener(){
	        @Override
	        public boolean handle(Event event){

	        if (event.toString().equals("mouseMoved")){
	        	TabItems_two.background(new TextureRegionDrawable(new TextureRegion(new Texture("csv/Capsqsqture.JPG"))));
	            return false;
	        }
	        else if(event.toString().equals("exit")){
	            //table1.setBackground(null);
	            //table1.background("");
	        	//TabItems_two.setBackground("csv/Capsqsqture.JPG");

	            return false;
	        }
	            return true;
	        }

	    });
	    
	    TabItems_tree.addListener(new FocusListener(){
	        @Override
	        public boolean handle(Event event){

	        if (event.toString().equals("mouseMoved")){
	        	TabItems_tree.background(new TextureRegionDrawable(new TextureRegion(new Texture("csv/Capsqsqture.JPG"))));
	            return false;
	        }
	        else if(event.toString().equals("exit")){
	            //table1.setBackground(null);
	            //table1.background("");
	        	//TabItems_tree.setBackground("csv/Capsqsqture.JPG");

	            return false;
	        }
	            return true;
	        }

	    });
		
		
	}
	
	Table label (String text) {
		Table table = new Table().debug();
		table.add(new Label(text, skin)).fill().expand();
		return table;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//cam.update();
		
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
	}

	
	
}
