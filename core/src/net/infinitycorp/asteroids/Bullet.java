package net.infinitycorp.asteroids;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {
    private final float speed = 400f;
    private float lifetime = 3f;

    private Texture texture;
    private Sprite sprite;
    private Movement movement;

    Bullet(float rotation, float startx, float starty){
        this.texture = new Texture("Bullet.png");
        this.sprite = new Sprite(texture);
        this.movement = new Movement(speed, rotation);
        sprite.setOriginCenter();

        sprite.setRotation(rotation);
        sprite.setPosition(startx, starty);
    }

    public boolean isAlive(){
        return lifetime < 0 ? false : true;
    }

    public void update(float delta){
        movement.moveSprite(sprite, delta);
        this.lifetime -= delta;
    }

    public void render(SpriteBatch sb){
        sprite.draw(sb);
    }
}
