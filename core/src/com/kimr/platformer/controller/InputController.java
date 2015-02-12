package com.kimr.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.kimr.platformer.model.InputControl;
import com.kimr.platformer.model.Spritesheet;

import java.util.ArrayList;

/**
 * Created by Student on 1/22/2015.
 */
public class InputController {
    private static Spritesheet spriteSheet;
    private static ArrayList<InputControl> inputControls;
    private static InputControl left;
    private static InputControl right;
    private static InputControl jump;
    private static InputControl down;

    public static void initializeController() {
        //initializing touch-controls spriteSheet.
        spriteSheet = new Spritesheet("img/touch-controls.png", 80, 80);    // width_scale = 480/6, height_scale = 240/3
        //initializing input controls.
        inputControls = new ArrayList<InputControl>();
        //left.
        left = new InputControl(new Vector2(0, 1),spriteSheet.spriteFrames[0], "left");
        inputControls.add(left);
        //right
        right = new InputControl(new Vector2(2, 1),spriteSheet.spriteFrames[1], "right");
        inputControls.add(right);

        jump = new InputControl(new Vector2(1, 2),spriteSheet.spriteFrames[2], "jump");
        inputControls.add(jump);

        down = new InputControl(new Vector2(1, 0),spriteSheet.spriteFrames[3], "down");
        inputControls.add(down);

        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch) {
        spriteBatch.begin();
        //left.draw(spriteBatch);
        //right.draw(spriteBatch);
        for(InputControl inputControl : inputControls) {
            inputControl.draw(spriteBatch);
        }
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter() {
        return new InputAdapter() {

            //Touch Controls.
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                //System.out.println("Touch Down");
                screenY = Gdx.graphics.getHeight() - screenY;

                for(InputControl inputControl : inputControls) {
                    if (inputControl.getBoundingBox().contains(screenX, screenY)) {
                        //PlayerController.movementAction = "left";
                        if(inputControl.action.equalsIgnoreCase("right")) {
                            PlayerController.movementAction = "right";
                        }
                        else if(inputControl.action.equalsIgnoreCase("left")) {
                            PlayerController.movementAction = "left";
                        }
                        else if(inputControl.action.equalsIgnoreCase("jump")) {
                            PlayerController.specialAction = "jump";
                        }
                        else if(inputControl.action.equalsIgnoreCase("down")) {
                            PlayerController.specialAction = "down";
                        }
                    }
                    //if (inputControl.getBoundingBox().contains(Gdx.graphics.getWidth() - screenX, screenY)) {
                    //    PlayerController.movementAction = "right";
                    //}
                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                //System.out.println("Touch Up");
                //PlayerController.movementAction = "left";

                screenY = Gdx.graphics.getHeight() - screenY;
                for(InputControl inputControl : inputControls) {
                    if (inputControl.getBoundingBox().contains(screenX, screenY)) {
                        //PlayerController.movementAction = "left";
                        if(inputControl.action.equalsIgnoreCase("right")) {
                            PlayerController.movementAction = "";
                        }
                        else if(inputControl.action.equalsIgnoreCase("left")) {
                            PlayerController.movementAction = "";
                        }
                        else if(inputControl.action.equalsIgnoreCase("jump")) {
                            PlayerController.specialAction = "";
                        }
                        else if(inputControl.action.equalsIgnoreCase("down")) {
                            PlayerController.specialAction = "";
                        }
                    }
                }
                return true;
            }

            //Keyboard Controls.
            @Override
            public boolean keyDown(int keycode) {
                if(keycode == Input.Keys.RIGHT) {
                    PlayerController.movementAction = "right";
                }
                else if(keycode == Input.Keys.LEFT) {
                    PlayerController.movementAction = "left";
                }
                if(keycode == Input.Keys.UP) {
                    PlayerController.specialAction = "jump";
                }
                else if(keycode == Input.Keys.DOWN) {
                    PlayerController.specialAction = "down";
                }
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                if(keycode == Input.Keys.RIGHT) {
                    PlayerController.movementAction = "";
                }
                else if(keycode == Input.Keys.LEFT) {
                    PlayerController.movementAction = "";
                }
                if(keycode == Input.Keys.UP) {
                    PlayerController.specialAction = "";
                }
                if(keycode == Input.Keys.DOWN) {
                    PlayerController.specialAction = "";
                }
                    return true;
            }
        };
    }
}
