package com.kimr.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.kimr.platformer.model.Player;

/**
 * Created by Student on 1/9/2015.
 */
public class PlayerController {
    public static Player player;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5;

    public static void initializeController() {
        player = new Player(new Vector2(3,3), 70, 100);
    }

    public static void update(float deltaTime) {
        //
        handleInput();
        //renders the players position on the map.
        player.update(deltaTime);
    }
    //Keyboard input to control the character.
    private static void handleInput() {
        //Vector2 is a point in space.
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        Vector2 position = player.physicsBody.getPosition();
        
        //Checks if the velocity.x is greater than the MAX_VELOCITY.
        if(Math.abs(velocity.x) > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }
        //Checks which key has been pressed.
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
        }
    }
}
