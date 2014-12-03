package com.kimr.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Student on 12/2/2014.
 */
public class Player {
    //Player position on map.
    public Vector2 position;
    //Player texture.
    public Texture spriteSheet;

    public Player() {
        position = new Vector2(0, 0);    //Vector position to the origin.
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));    //Set textures as the alien images.

    }
    //draw spriteSheet for player.
    public void draw(Batch spriteBatch){
        spriteBatch.draw(spriteSheet, 0, 0, 70, 100);   //sets the length and with of the player image.
    }
    //update properties for player.
    public void update(float deltaTime){

    }
}