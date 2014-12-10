package com.kimr.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    //Player texture.
    public Texture spriteSheet;
    //Stores our players (sprites).
    public TextureRegion[] spriteFrames;    //one dimensional array.
    //Player animation.
    public Animation animation;

    public Spritesheet(String pathToFile, int width, int height) {
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));    //Set textures as the specified image.

        //splits the spriteSheet by width and height.
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);    //two dimensional arrays, [rows] [columns].

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

    public Animation createAnimation(int anim1, int anim2) {
        //Creating a new array to store our walking sprite animation.
        TextureRegion[] animationFrames = new TextureRegion[2];
        //Assigning sprite to animationFrames.
        animationFrames[0] = spriteFrames[anim1];
        animationFrames[1] = spriteFrames[anim2];
        //Determining frame duration for animation.
        animation = new Animation(.25f, animationFrames);
        //returns animation variable.
        return animation;
    }
}
