package net.infinitycorp.asteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ship{
    private float accelerationSpeed = 150f;
    private float maxSpeed = 300f;
    private float rotationSpeed = 200f;
    private float shootSpeed;
    private float shotCooldown;

    private final Movement movement = new Movement(maxSpeed, rotationSpeed, 0,0, accelerationSpeed);
    List<Bullet> bullets = new ArrayList<>();

    Texture texture;
    Sprite sprite;

    Ship (){
        texture = new Texture("Ship.png");
        sprite = new Sprite(texture);
//        sprite.setOriginCenter();
        sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
        sprite.setPosition(250, 250);
        sprite.setRotation(180);
        shootSpeed = 2;
    }

    private boolean canShoot(){
        return shotCooldown < 0 ? true : false;
    }

    private void createBullet(){
        bullets.add(new Bullet(sprite.getRotation(), sprite.getX(), sprite.getY()));
        shotCooldown = 1;
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

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            if(canShoot()){
                createBullet();
            }
        }

        shotCooldown -= shootSpeed * delta;
        movement.moveSprite(sprite, delta);

        for (ListIterator<Bullet> bulletIterator = bullets.listIterator(); bulletIterator.hasNext();){
            Bullet b = bulletIterator.next();
            b.update(delta);
            if(!b.isAlive()){
                bulletIterator.remove();
            }
        }

    }

    public void render(SpriteBatch sb){
        sprite.draw(sb);
        for (Bullet bullet : bullets) {
            bullet.render(sb);
        }
    }
}
