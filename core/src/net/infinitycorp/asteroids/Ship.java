package net.infinitycorp.asteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship{
    private final float accelerationSpeed = 5f;
    private final float maxSpeed = 5;
    private final float rotationSpeed = 200;


    private float velx;
    private float vely;

    private boolean moveForward = false;
    private boolean rotateAnticlockwise = false;
    private boolean rotateClockwise = false;


    Texture texture;
    Sprite sprite;

    Ship (){
        texture = new Texture("Ship.png");
        sprite = new Sprite(texture);
        sprite.setOriginCenter();
        sprite.setPosition(250, 250);
        sprite.setRotation(180);
        velx = 0;
        vely = 0;
    }

    public void update(float delta){
        sprite.translate(velx, vely);
        float windowHeight = Gdx.graphics.getHeight();
        float windowWidth = Gdx.graphics.getWidth();
        float xpos = sprite.getX();
        float ypos = sprite.getY();


        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            sprite.rotate(rotationSpeed * delta);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            sprite.rotate(-rotationSpeed * delta);
        }

        float rotation = sprite.getRotation();
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            velx += Math.cos(Math.toRadians(rotation)) * accelerationSpeed * delta;
            vely += Math.sin(Math.toRadians(rotation)) * accelerationSpeed * delta;

            if(velx > maxSpeed){
                velx = maxSpeed;
            }
            if(vely > maxSpeed){
                vely = maxSpeed;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            velx = vely = 0;
        }

        if (xpos > windowWidth){
            sprite.setX(5);
        }
        else if (xpos < 0){
            sprite.setX(windowWidth - 5);
        }

        if (ypos > windowHeight){
            sprite.setY(5);
        }
        else if(ypos < 0){
            sprite.setY(windowHeight - 5);
        }
    }

    public void render(SpriteBatch sb){
        sprite.draw(sb);
    }
}
