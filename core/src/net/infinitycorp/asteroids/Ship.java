package net.infinitycorp.asteroids;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ship{
    float velx;
    float vely;


    Texture texture;
    Sprite sprite;

    Ship (){
        texture = new Texture("Ship.png");
        sprite = new Sprite(texture);
        sprite.setPosition(250, 250);
        sprite.setRotation(90);
        velx = 1;
        vely = 1;
    }

    public void update(float delta){
        sprite.setX(sprite.getX() + velx);
        sprite.setY(sprite.getY() + vely);
    }

    public void render(SpriteBatch sb){
        sprite.draw(sb);
    }
}
