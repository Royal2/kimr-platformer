package com.kimr.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.kimr.platformer.model.InputControl;
import com.kimr.platformer.model.Spritesheet;

/**
 * Created by Student on 1/22/2015.
 */
public class InputController {
    private static Spritesheet spriteSheet;
    private static InputControl left;
    private static InputControl right;

    public static void initializeController() {
        spriteSheet = new Spritesheet("img/touch-controls.png", 80, 80);    // width_scale = 480/6, height_scale = 240/3
        //left.
        left = new InputControl(new Vector2(0, 0),spriteSheet.spriteFrames[0], "left");
        //right
        right = new InputControl(new Vector2(13, 0),spriteSheet.spriteFrames[1], "right");

        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch) {
        spriteBatch.begin();
        left.draw(spriteBatch);
        right.draw(spriteBatch);
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter() {
        return new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                //System.out.println("Touch Down");

                if(left.getBoundingBox().contains(screenX, Gdx.graphics.getHeight() - screenY)) {
                    PlayerController.movementAction = "left";
                }
                if(left.getBoundingBox().contains(Gdx.graphics.getWidth() - screenX, Gdx.graphics.getHeight() - screenY)) {
                    PlayerController.movementAction = "right";
                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                //System.out.println("Touch Up");
                //PlayerController.movementAction = "left";
                return true;
            }
        };
    }
}
