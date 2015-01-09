package com.kimr.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.kimr.platformer.controller.LevelController;
import com.kimr.platformer.view.GameScreen;

import java.util.HashMap;

/**
 * Created by Student on 12/2/2014.
 */
public class Player {
    //Player position on map.
    public Vector2 position;

    public Spritesheet spriteSheet;

    public String currentAnimation;

    public float width;
    public float height;

    private float stateTime;
    //Creates an animation table.
    private HashMap<String, Animation> animations;    //<Key, Value>

    public Player( int width, int height) {
        position = new Vector2(3, 2);    //Vector positions the player.
        //Initializing HashMap table.
        animations = new HashMap<String, Animation>();

        //Set width and height of player.
        this.width = width * (1/70f);
        this.height = height * (1/70f);

        spriteSheet = new Spritesheet("img/aliens.png", width, height);
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
        currentAnimation = "walkFlip";

        //Initializing stateTime variable.
        stateTime = 0f;

        //Properties of body.
        BodyDef bodyDefinition = new BodyDef(); //Creating bodyDefinition.
        bodyDefinition.type = BodyDef.BodyType.DynamicBody; //Defining body type.
        bodyDefinition.position.set(position);  //Getting position of sprite on game screen, then sets to body.

        Body playerBody = LevelController.gameWorld.createBody(bodyDefinition);  //Creating body to game world.
        playerBody.setUserData(this);   //sets user data.

        //Setting shape of player body.
        PolygonShape rectangleShape = new PolygonShape();   //Creating shape.
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f);  //Center of player body.

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;   //Attatches shape to body.

        playerBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();   //Deletes the shape.

    }
    //draw spriteSheet for player.
    public void draw(Batch spriteBatch){
        //inputs the position of the character.
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);   //sets the length and width of the player image. Divided by 70 to convert to units.

    }
    //update properties for player.
    public void update(float deltaTime){
        //Adds one to the x position of the player, moving the position of the player along the x-axis.
        //position.y += deltaTime;
        //Set stateTime to game time.
        stateTime += deltaTime;
    }
}