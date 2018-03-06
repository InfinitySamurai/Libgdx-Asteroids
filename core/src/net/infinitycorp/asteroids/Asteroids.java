package net.infinitycorp.asteroids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Asteroids extends ApplicationAdapter {
	SpriteBatch sb;
	Texture img;
	BitmapFont font;
	Ship ship;

	List<Bullet> bullets = new ArrayList<Bullet>();
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLUE);
		ship = new Ship();

		bullets.add(new Bullet(20, 500,500));
	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ship.update(delta);

		for (ListIterator<Bullet> bulletIterator = bullets.listIterator(); bulletIterator.hasNext();){
			Bullet b = bulletIterator.next();
			b.update(delta);
			if(!b.isAlive()){
				bulletIterator.remove();
			}
		}

		sb.begin();
		ship.render(sb);
		for (Bullet bullet : bullets) {
			bullet.render(sb);
		}
		font.draw(sb, "Hello World", 200, 300);
		sb.end();
	}
	
	@Override
	public void dispose () {
		sb.dispose();
		img.dispose();
	}
}
