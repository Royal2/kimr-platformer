package com.kimr.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.kimr.platformer.controller.LevelController;

/**
 * Created by Student on 1/15/2015.
 */
public class Enemy extends Sprite {
    public Enemy(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        //animations.
        animations.put("stand", spriteSheet.createAnimation(0, 1, .25f));
        animations.put("dead", spriteSheet.createAnimation(2, 2, .25f));
        //Animation Key (String).
        currentAnimation = "stand";

        //Properties of body.
        BodyDef bodyDefinition = new BodyDef(); //Creating bodyDefinition.
        bodyDefinition.type = BodyDef.BodyType.DynamicBody; //Defining body type.
        bodyDefinition.position.set(position);  //Getting position of sprite on game screen, then sets to body.

        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);  //Creating body to game world.
        physicsBody.setUserData(this);   //sets user data.

        //Setting shape of player body.
        PolygonShape rectangleShape = new PolygonShape();   //Creating shape.
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f);  //Center of player body.

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;   //Attatches shape to body.

        physicsBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();   //Deletes the shape.

    }
    public void draw(Batch spriteBatch){
        super.draw(spriteBatch);
    }
    //update properties for enemy.
    public void update(float deltaTime){
        super.update(deltaTime);
    }
}
