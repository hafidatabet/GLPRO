package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.EternityII;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = EternityII.TITLE + " v " + EternityII.VERSION;
		cfg.vSyncEnabled = true;
		cfg.width = 900;
		cfg.height = 600;
		
		new LwjglApplication(new EternityII(), cfg);
	}
}
