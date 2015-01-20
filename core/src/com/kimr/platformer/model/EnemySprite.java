package com.kimr.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.kimr.platformer.controller.LevelController;

import java.util.HashMap;

/**
 * Created by Student on 1/15/2015.
 */
public class EnemySprite {
    public Body physicsBody;
    //position on map.
    public Vector2 position;
    //spriteSheet.
    public Spritesheet spriteSheet;
    //currentAnimation.
    protected String currentAnimation;

    public float width;
    public float height;

    protected float stateTime;
    //Creates an animation table.
    protected HashMap<String, Animation> animations;    //<Key, Value>

    public EnemySprite(Vector2 position, int width, int height, String sheetPath) {
        this.position = position;    //Positions the enemy.
        //Initializing HashMap table.
        animations = new HashMap<String, Animation>();

        //Set width and height of enemy.
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;

        //Initializing spriteSheet.
        spriteSheet = new Spritesheet(sheetPath, width, height);
        spriteSheet = new Spritesheet(sheetPath, width, height);
        //Initializing stateTime variable.
        stateTime = 0f;

    }
    public void draw(Batch spriteBatch){
        //inputs the position of the character.
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);   //sets the length and width of the enemy image.
    }
    //update properties for enemy.
    public void update(float deltaTime){
        stateTime += deltaTime;
    }
}
