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

    public static String movementAction;
    public static String specialAction;

    private enum State {
        Idle, Walk, Jump, JumpFlip;
    }
    private static State playerState;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5;

    public static void initializeController() {
        player = new Player(new Vector2(3,3), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";
        playerState = State.Idle;
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
        //Right Key Binding.
        if(movementAction.equalsIgnoreCase("right")) {
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
            player.direction = "right";
        }
        //Left Key Binding.
        //if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        if(movementAction.equalsIgnoreCase("left")) {
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0f, position.x, position.y, true);
            player.direction = "left";
        }
        //Jump Key Binding.
        if(specialAction.equalsIgnoreCase("jump")) {
            player.physicsBody.applyLinearImpulse(0f, 1f, position.x, position.y, true);
            player.direction = "jump";
        }

        if (Math.abs(velocity.y) > 0) {
            if(Math.abs(velocity.x) > 0) {
                playerState = State.Jump;
            }
            else {
                playerState = State.JumpFlip;
            }
        }
        else if (Math.abs(velocity.x) > 0) {
            playerState = State.Walk;
        }
        else {
            playerState = State.Idle;
        }
        setCurrentAnimation();
    }

    private static void setCurrentAnimation() {
        if (player.direction.equals("right")) {
            setRightAnimation();
        }
        if (player.direction.equals("left")) {
            setLeftAnimation();
        }
        if (player.direction.equals("jump")) {
            setJumpAnimation();
        }
        if (player.direction.equals("jumpFlip")) {
            setJumpFlipAnimation();
        }

    }
    private static void setJumpAnimation() {
        if (playerState == State.Jump) {
            player.currentAnimation = "jump";
        }
        else if (playerState == State.Idle) {
            player.currentAnimation = "idle";
        }
    }
    private static void setJumpFlipAnimation() {
        if (playerState == State.JumpFlip) {
            player.currentAnimation = "jumpFlip";
        }
        else if (playerState == State.Idle) {
            player.currentAnimation = "idleFlip";
        }
    }
    private static void setRightAnimation() {
        if (playerState == State.Walk) {
            player.currentAnimation = "walk";
        }
        else if (playerState == State.Idle) {
            player.currentAnimation = "idle";
        }
    }
    private static void setLeftAnimation() {
        if (playerState == State.Walk) {
            player.currentAnimation = "walkFlip";
        }
        else if (playerState == State.Idle) {
            player.currentAnimation = "idleFlip";
        }
    }
}