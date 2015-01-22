package com.kimr.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.kimr.platformer.controller.LevelController;

/**
 * Created by Student on 1/22/2015.
 */
public class InputControl {
    public String action;
    public Vector2 position;

    private TextureRegion textureRegion;
    private float width;
    private float height;

    public InputControl(Vector2 position, TextureRegion textureRegion, String action) {
        this.position = position;
        this.action = action;
        this.textureRegion = textureRegion;

        width = textureRegion.getRegionWidth();
        height = textureRegion.getRegionHeight();

    }

    public void draw(Batch spriteBatch) {
        //draws textureRegion onto screen.
        spriteBatch.draw(textureRegion, position.x, position.y, width * LevelController.UNIT_SCALE, height * LevelController.UNIT_SCALE);
    }
}
