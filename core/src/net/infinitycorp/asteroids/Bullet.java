package net.infinitycorp.asteroids;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {
    private final float speed = 400f;
    private final float lifetime = 2f;
    private float velx;
    private float vely;

    private Texture texture;
    private Sprite sprite;

    Bullet(float rotation, float startx, float starty){
        this.texture = new Texture("Bullet.png");
        this.sprite = new Sprite(texture);

        velx = (float) Math.cos(Math.toRadians(rotation)) * speed;
        vely = (float) Math.sin(Math.toRadians(rotation)) * speed;

        sprite.setRotation(rotation);
        sprite.setPosition(startx, starty);
    }

    public void update(float delta){
        sprite.translate(velx * delta, vely * delta);
    }

    public void render(SpriteBatch sb){
        sprite.draw(sb);
    }
}
