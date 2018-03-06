package net.infinitycorp.asteroids;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Asteroid {

    private Movement movement;

    private Texture texture;
    private Sprite sprite;

    Asteroid(float speed, float rotation){
        movement = new Movement(speed, rotation);
    }
}
