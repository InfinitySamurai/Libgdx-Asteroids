package net.infinitycorp.asteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Asteroid {

    AsteroidTypes asteroidTypes;

    private Movement movement;
    private Sprite sprite;

    private Random random = new Random();


    Asteroid(float speed, float rotation, AsteroidTypes asteroidType){
        movement = new Movement(speed, rotation);

        sprite = createSpriteFromEnum(asteroidType);

        sprite.setOriginCenter();
        sprite.setScale(0.75f);

        randomizeSpawnLocation();
    }

    private Sprite createSpriteFromEnum(AsteroidTypes type){
        if(type == asteroidTypes.BIG){
            return new Sprite(new Texture("asteroid_big.png"));
        }
        if(type == asteroidTypes.MEDIUM){
            return new Sprite(new Texture("asteroid_medium.png"));
        }
        if(type == asteroidTypes.SMALL){
            return new Sprite(new Texture("asteroid_small.png"));
        }

        throw new Error("Enum type not supported for these asteroid bois");
    }

    private void randomizeSpawnLocation(){
        sprite.setX(random.nextFloat()* Gdx.graphics.getWidth());
        sprite.setY(random.nextFloat() * Gdx.graphics.getHeight());
    }

    public void update(float delta){

    }

    public void render(SpriteBatch sb){
        sprite.draw(sb);

    }

}
