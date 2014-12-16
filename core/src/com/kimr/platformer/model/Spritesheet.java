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

    public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed) {
        //counter gets the number of frames to use in the animation.
        int counter = (lastFrame + 1) - startFrame;  //+1 to count for the zero in the array.

        //Creating a new array to store our sprite animation.
        TextureRegion[] animationFrames = new TextureRegion[counter];

        //Creates animation, by getting its frames.
        for(int index = lastFrame; index >= startFrame; index--){
            animationFrames[--counter] = spriteFrames[index];  //"--" before "counter" decrements counter before accessing it.
        }

        //Determining frame duration for animation.
        return new Animation(animationSpeed, animationFrames);
    }

    public Animation flipAnimation(Animation originalAnimation, boolean flipX, boolean flipY) {
        //Gets frameCount from originalAnimation array length.
        int frameCount = originalAnimation.getKeyFrames().length;
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];

        //Creates flipped animation.
        for(int index = 0; index < frameCount; index++){
            flippedFrames[index] = new TextureRegion(originalAnimation.getKeyFrames()[index]);  //Creates a new TextureRegion for flipped animations.
            flippedFrames[index].flip(flipX, flipY);  //Flips frames across x-axis or y-axis.
        }

        //returns flipped animation.
        return new Animation(originalAnimation.getFrameDuration(), flippedFrames);
    }
}