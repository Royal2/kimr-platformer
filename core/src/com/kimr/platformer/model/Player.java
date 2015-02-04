package com.kimr.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.kimr.platformer.controller.LevelController;

import java.awt.Polygon;

/**
 * Created by Student on 12/2/2014.
 */
public class Player extends Sprite {

    public Player(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        //animations.
        animations.put("stand", spriteSheet.createAnimation(33, 33, .25f));
        animations.put("climb", spriteSheet.createAnimation(34, 35, .25f));
        animations.put("duck", spriteSheet.createAnimation(36, 36, .25f));
        animations.put("hurt", spriteSheet.createAnimation(37, 37, .25f));
        animations.put("jump", spriteSheet.createAnimation(38, 38, .25f));
        animations.put("idle", spriteSheet.createAnimation(39, 39, .25f));
        animations.put("swim", spriteSheet.createAnimation(40, 41, .25f));
        animations.put("walk", spriteSheet.createAnimation(42, 43, .25f));
        //flip animations.
        animations.put("duckFlip", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("hurtFlip", spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("jumpFlip", spriteSheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("idleFlip", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("swimFlip", spriteSheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("walkFlip", spriteSheet.flipAnimation(animations.get("walk"), true, false));
        //animation = spriteSheet.flipAnimation(animation, true, false);

        //Animation Key (String).
        currentAnimation = "walk";

        //Properties of body.
        BodyDef bodyDefinition = new BodyDef(); //Creating bodyDefinition.
        bodyDefinition.type = BodyDef.BodyType.DynamicBody; //Defining body type.
        bodyDefinition.position.set(position);  //Getting position of sprite on game screen, then sets to body.

        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);  //Creating body to game world.
        physicsBody.setUserData(this);   //sets user data.
        //Sets fixed rotation.
        physicsBody.setFixedRotation(true);

        //Setting shape of player body.
        PolygonShape rectangleShape = new PolygonShape();   //Creating shape.
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f);  //Center of player body.

        PolygonShape sensorShape = new PolygonShape();
        sensorShape.setAsBox(this.width / 2.2f, this.height / 32f, new Vector2(this.width / 2f, 0f), 0f);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;   //Attatches shape to body.

        FixtureDef fixtureDefinitionSensor = new FixtureDef();
        fixtureDefinitionSensor.shape = sensorShape;
        fixtureDefinitionSensor.isSensor = true;

        //Set density.
        fixtureDefinition.density = 0.5f;

        physicsBody.createFixture(fixtureDefinition);
        physicsBody.createFixture(fixtureDefinitionSensor);
        rectangleShape.dispose();   //Deletes the shape.
        sensorShape.dispose();

    }
    //draw spriteSheet for player.
    public void draw(Batch spriteBatch){
        //inputs the position of the character.
        //spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);   //sets the length and width of the player image. Divided by 70 to convert to units.
        super.draw(spriteBatch);    //Calling a parent class.
    }
    //update properties for player.
    public void update(float deltaTime){
        //Adds one to the x position of the player, moving the position of the player along the x-axis.
        //position.y += deltaTime;
        //Set stateTime to game time.
        //stateTime += deltaTime;
        super.update(deltaTime);
    }
}