package net.infinitycorp.asteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship{
    private final float accelerationSpeed = 150f;
    private final float maxSpeed = 300f;
    private final float rotationSpeed = 200f;

    private final Movement movement = new Movement(maxSpeed, rotationSpeed, 0,0, accelerationSpeed);

    Texture texture;
    Sprite sprite;

    Ship (){
        texture = new Texture("Ship.png");
        sprite = new Sprite(texture);
        sprite.setOriginCenter();
        sprite.setPosition(250, 250);
        sprite.setRotation(180);
    }

    public void update(float delta){

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            movement.rotateSprite(sprite, 1, delta);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            movement.rotateSprite(sprite, -1, delta);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            movement.changeVelocity(sprite, delta);
        }

        movement.moveSprite(sprite, delta);
    }

    public void render(SpriteBatch sb){
        sprite.draw(sb);
    }
}
