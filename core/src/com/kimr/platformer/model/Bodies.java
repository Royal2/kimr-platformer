package com.kimr.platformer.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.kimr.platformer.controller.LevelController;

/**
 * Created by Student on 1/20/2015.
 */
public class Bodies {
    public static void createBody(MapObject mapObject) {
        //Gets type of map object.
        String bodyType = mapObject.getProperties().get("type").toString();
        //Checks if body type is solid.
        if(bodyType.equalsIgnoreCase("solid")) {
            RectangleMapObject rectangleObject = (RectangleMapObject)mapObject;
            //Create bodyDefinition.
            BodyDef bodyDefinition = new BodyDef();
            //Set type.
            bodyDefinition.type = BodyDef.BodyType.StaticBody;  //StaticBody stays in place.
            //Set position.
            bodyDefinition.position.set(rectangleObject.getRectangle().x * LevelController.UNIT_SCALE,
                    rectangleObject.getRectangle().y * LevelController.UNIT_SCALE);
            //Create body.
            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            //Create shape.
            PolygonShape rectangleShape = new PolygonShape();
            //Create rectangle.
            rectangleShape.setAsBox(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2f,
                    rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2f,
                    new Vector2(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2f,
                            rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2f), 0f);
            //Create fixtureDefinition.
            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = rectangleShape;
            //Attatch shape to physics body.
            physicsBody.createFixture(fixtureDefinition);
            rectangleShape.dispose();

        }
    }
}