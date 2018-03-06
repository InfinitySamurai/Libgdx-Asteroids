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
import java.util.Random;

public class Asteroids extends ApplicationAdapter {
	private SpriteBatch sb;
	private Texture img;
	private BitmapFont font;
	private Ship ship;

	List<Asteroid> asteroids = new ArrayList<>();


	
	@Override
	public void create () {
		sb = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLUE);
		ship = new Ship();
		asteroids.add(new Asteroid(100, 0, AsteroidTypes.BIG));
	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ship.update(delta);

		for (ListIterator<Asteroid> asteroidIterator = asteroids.listIterator(); asteroidIterator.hasNext();){
			Asteroid a = asteroidIterator.next();
			a.update(delta);
		}

		sb.begin();
		ship.render(sb);

		for(Asteroid a : asteroids){
			a.render(sb);
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
