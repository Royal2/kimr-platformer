package com.kimr.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

/**
 * Created by Student on 12/2/2014.
 */
public class Player {
    //Player position on map.
    public Vector2 position;

    public Spritesheet spriteSheet;

    public int width;
    public int height;

    private float stateTime;
    //Creates an animation table.
    private HashMap<String, Animation> animations;    //<Key, Value>

    public Player() {
        position = new Vector2(1, 2);    //Vector positions the player.
        //Initializing HashMap table.
        animations = new HashMap<String, Animation>();

        //Set width and height of player.
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        //animations.
        animations.put("stand", spriteSheet.createAnimation(33, 33, .25f));
        animations.put("climb", spriteSheet.createAnimation(34, 35, .25f));
        animations.put("duck", spriteSheet.createAnimation(36, 36, .25f));
        animations.put("hurt", spriteSheet.createAnimation(37, 37, .25f));
        animations.put("jump", spriteSheet.createAnimation(38, 38, .25f));
        animations.put("idle", spriteSheet.createAnimation(39, 39, .25f));
        animations.put("swim", spriteSheet.createAnimation(40, 41, .25f));
        animations.put("walk", spriteSheet.createAnimation(42, 43, .25f));
        //flip animations.
        animations.put("duckFlip", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("hurtFlip", spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("jumpFlip", spriteSheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("idleFlip", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("swimFlip", spriteSheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("walkFlip", spriteSheet.flipAnimation(animations.get("walk"), true, false));
        //animation = spriteSheet.flipAnimation(animation, true, false);

        //Initializing stateTime variable.
        stateTime = 0f;

    }
    //draw spriteSheet for player.
    public void draw(Batch spriteBatch){
        //inputs the position of the character.
        spriteBatch.draw(animations.get("walk").getKeyFrame(stateTime, true), position.x, position.y, width*(1/70f), height*(1/70f));   //sets the length and width of the player image. Divided by 70 to convert to units.

    }
    //update properties for player.
    public void update(float deltaTime){
        //Adds one to the x position of the player, moving the position of the player along the x-axis.
        position.y += deltaTime;
        //Set stateTime to game time.
        stateTime += deltaTime;
    }
}