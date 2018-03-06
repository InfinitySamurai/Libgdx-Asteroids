package net.infinitycorp.asteroids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Asteroids extends ApplicationAdapter {
	SpriteBatch sb;
	Texture img;
	BitmapFont font;
	Ship ship;
	Bullet bullet;
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLUE);
		ship = new Ship();
		bullet = new Bullet(45, 500,500);
	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		ship.update(delta);
		bullet.update(delta);
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		ship.render(sb);
		bullet.render(sb);
		font.draw(sb, "Hello World", 200, 300);
		sb.end();
	}
	
	@Override
	public void dispose () {
		sb.dispose();
		img.dispose();
	}
}
