package com.kimr.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.kimr.platformer.controller.LevelController;

import java.util.HashMap;

/**
 * Created by Student on 1/13/2015.
 */
public class Sprite {
    //
    public Body physicsBody;
    //position on map.
    public Vector2 position;
    //spriteSheet.
    public Spritesheet spriteSheet;
    //currentAnimation.
    public String currentAnimation;
    //player's initial direction.
    public String direction;

    public float width;
    public float height;

    protected float stateTime;
    //Creates an animation table.
    protected HashMap<String, Animation> animations;    //<Key, Value>

    public Sprite(Vector2 position, int width, int height, String sheetPath) {
        this.position = position;    //Positions the player.
        //Initializing HashMap table.
        animations = new HashMap<String, Animation>();

        //Set width and height of player.
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;

        //Initializing spriteSheet.
        spriteSheet = new Spritesheet(sheetPath, width, height);
        //Initializing stateTime variable.
        stateTime = 0f;
        direction = "right";
    }
    //draw spriteSheet for player.
    public void draw(Batch spriteBatch){
        //inputs the position of the character.
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);   //sets the length and width of the player image. Divided by 70 to convert to units.

    }
    //update properties for player.
    public void update(float deltaTime){
        //Adds one to the x position of the player, moving the position of the player along the x-axis.
        //position.y += deltaTime;
        //Set stateTime to game time.
        stateTime += deltaTime;
    }
}
