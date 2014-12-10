package com.kimr.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Student on 12/2/2014.
 */
public class Player {
    //Player position on map.
    public Vector2 position;
    //Player animation.
    public Animation animation;

    public Spritesheet spriteSheet;

    public int width;
    public int height;

    private float stateTime;

    public Player() {
        position = new Vector2(1, 2);    //Vector positions the player.
        //Set width and height of player.
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        animation = spriteSheet.createAnimation(34, 35);



        //Initializing stateTime variable.
        stateTime = 0f;

    }
    //draw spriteSheet for player.
    public void draw(Batch spriteBatch){
        //inputs the position of the character.
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, width*(1/70f), height*(1/70f));   //sets the length and width of the player image. Divided by 70 to convert to units.

    }
    //update properties for player.
    public void update(float deltaTime){
        //Adds one to the x position of the player, moving the position of the player along the x-axis.
        position.y += deltaTime;
        //Set stateTime to game time.
        stateTime += deltaTime;
    }
}