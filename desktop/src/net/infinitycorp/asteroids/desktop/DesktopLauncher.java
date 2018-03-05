package net.infinitycorp.asteroids.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.infinitycorp.asteroids.Asteroids;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.width = 1024;
		cfg.height = 768;
		new LwjglApplication(new Asteroids(), cfg);
	}
}
