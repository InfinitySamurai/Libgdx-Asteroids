package net.infinitycorp.asteroids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Asteroids extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	Ship ship;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		font.setColor(Color.BLUE);
		ship = new Ship();
	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		ship.update(delta);
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		ship.render(batch);
		font.draw(batch, "Hello World", 200, 300);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
