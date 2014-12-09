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
    //Player texture.
    public Texture spriteSheet;
    //Stores our players (sprites).
    public TextureRegion[] spriteFrames;    //one dimensional array.

    //Player animation.
    public Animation animation;

    private float stateTime;

    public Player() {
        position = new Vector2(1, 2);    //Vector positions the player.
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));    //Set textures as the alien images.

        //splits the spriteSheet by width and height.
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100);    //two dimensional arrays, [rows] [columns].

        //counter counts number of aliens.
        int counter = 0;    //start at origin.
        for(int row = 0; row < spriteSheetFrames.length; row++) {
            for(int column = 0; column < spriteSheetFrames[row].length; column++) {
                counter++;
            }
        }

        //assigns counter into spriteFrames dimensional array.
        spriteFrames = new TextureRegion[counter];
        //set counter back to 0.
        counter = 0;
        //checks spriteSheet frames, then takes each row and stores it into row.
        for(TextureRegion[] row : spriteSheetFrames) {
            //stores each column(sprite) into row.
            for(TextureRegion sprite : row) {
                //assigns each sprite into spriteFrames.
                spriteFrames[counter++] = sprite;
            }
        }

        //Creating a new array to store our walking sprite animation.
        TextureRegion[] animationFrames = new TextureRegion[2];
        //Assigning sprite to animationFrames.
        animationFrames[0] = spriteFrames[34];
        animationFrames[1] = spriteFrames[35];
        //Determining frame duration for animation.
        animation = new Animation(.25f, animationFrames);
        //Initializing stateTime variable.
        stateTime = 0f;

    }
    //draw spriteSheet for player.
    public void draw(Batch spriteBatch){
        //inputs the position of the character.
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70*(1/70f), 100*(1/70f));   //sets the length and width of the player image. Divided by 70 to convert to units.

    }
    //update properties for player.
    public void update(float deltaTime){
        //Adds one to the x position of the player, moving the position of the player along the x-axis.
        position.y += deltaTime;
        //Set stateTime to game time.
        stateTime += deltaTime;
    }
}