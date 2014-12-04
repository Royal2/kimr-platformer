package com.kimr.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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

    public TextureRegion[] spriteFrames;    //one dimensional array.

    public Player() {
        position = new Vector2(0, 0);    //Vector position to the origin.
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

    }
    //draw spriteSheet for player.
    public void draw(Batch spriteBatch){
        spriteBatch.draw(spriteFrames[4], 0, 0, 70, 100);   //sets the length and width of the player image.

    }
    //update properties for player.
    public void update(float deltaTime){

    }
}