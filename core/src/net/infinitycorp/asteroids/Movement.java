package net.infinitycorp.asteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Movement {
    private float maxSpeed;
    private float accelerationSpeed;
    private float rotationSpeed;
    private float velx;
    private float vely;
    private float windowHeight;
    private float windowWidth;

    Movement(float maxSpeed, float rotationSpeed, float velx, float vely, float accelerationSpeed){
        this.maxSpeed = maxSpeed;
        this.rotationSpeed = rotationSpeed;
        this.velx = velx;
        this.vely = vely;
        this.accelerationSpeed = accelerationSpeed;

        this.windowHeight = Gdx.graphics.getHeight();
        this.windowWidth = Gdx.graphics.getWidth();
    }

    public void moveSprite(Sprite sprite, float delta){
        float rotation = sprite.getRotation();
        velx += Math.cos(Math.toRadians(rotation)) * accelerationSpeed * delta;
        vely += Math.sin(Math.toRadians(rotation)) * accelerationSpeed * delta;

        if(Math.abs(velx) > maxSpeed){
            velx = Math.signum(velx) * maxSpeed;
        }
        if(Math.abs(vely) > maxSpeed){
            vely = Math.signum(vely) * maxSpeed;
        }

        sprite.translate(velx * delta, vely * delta);

        checkScreenBounds(sprite);

        return;
    }

    public void rotateSprite(Sprite sprite, int direction, float delta){
        sprite.rotate(direction * rotationSpeed * delta);
    }

    private void checkScreenBounds(Sprite sprite){
        float xpos = sprite.getX();
        float ypos = sprite.getY();

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
}
