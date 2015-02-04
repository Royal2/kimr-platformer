package com.kimr.platformer.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
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
        //Checks if body type is Slope.
        else if(bodyType.equalsIgnoreCase("slope")) {
            PolygonMapObject polygonObject = (PolygonMapObject)mapObject;
            //Create bodyDefinition.
            BodyDef bodyDefinition = new BodyDef();
            //Set type.
            bodyDefinition.type = BodyDef.BodyType.StaticBody;  //StaticBody stays in place.
            //Set position.
            bodyDefinition.position.set(polygonObject.getPolygon().getX() * LevelController.UNIT_SCALE,
                    polygonObject.getPolygon().getY() * LevelController.UNIT_SCALE);
            //Create body.
            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            //Create shape.
            PolygonShape polygonShape = new PolygonShape();
            //Create rectangle.
            polygonShape.set(polygonObject.getPolygon().getVertices());
            float[] transformedVertices = new float[polygonObject.getPolygon().getVertices().length];
            //Gets all our vertices, scales, then stores them into transformedVertices.
            for(int index = 0; index < transformedVertices.length; index++) {
                transformedVertices[index] = polygonObject.getPolygon().getVertices()[index] * LevelController.UNIT_SCALE;
            }
            polygonShape.set(transformedVertices);
            //Create fixtureDefinition.
            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = polygonShape;
            //Attatch shape to physics body.
            physicsBody.createFixture(fixtureDefinition);
            polygonShape.dispose();

        }

        //Checks if body type is Ground.
        else if(bodyType.equalsIgnoreCase("ground")) {
            PolylineMapObject polylineObject = (PolylineMapObject)mapObject;
            //Create bodyDefinition.
            BodyDef bodyDefinition = new BodyDef();
            //Set type.
            bodyDefinition.type = BodyDef.BodyType.StaticBody;  //StaticBody stays in place.
            //Set position.
            bodyDefinition.position.set(polylineObject.getPolyline().getX() * LevelController.UNIT_SCALE,
                    polylineObject.getPolyline().getY() * LevelController.UNIT_SCALE);
            //Create body.
            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            //Create shape.
            ChainShape chainShape = new ChainShape();
            //Create line.
            float[] transformedVertices = new float[polylineObject.getPolyline().getVertices().length];
            //Gets all our vertices, scales, then stores them into transformedVertices.
            for(int index = 0; index < transformedVertices.length; index++) {
                transformedVertices[index] = polylineObject.getPolyline().getVertices()[index] * LevelController.UNIT_SCALE;
            }
            chainShape.createChain(transformedVertices);
            //Create fixtureDefinition.
            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = chainShape;
            //Set friction.
            fixtureDefinition.friction = 2.5f;
            //Attach shape to physics body.
            physicsBody.createFixture(fixtureDefinition);
            chainShape.dispose();

        }

        else if(bodyType.equalsIgnoreCase("block")) {
            RectangleMapObject rectangleObject = (RectangleMapObject)mapObject;
            //Create bodyDefinition.
            BodyDef bodyDefinition = new BodyDef();
            //Set type.
            bodyDefinition.type = BodyDef.BodyType.DynamicBody;  //StaticBody stays in place.
            //Set position.
            bodyDefinition.position.set(rectangleObject.getRectangle().x * LevelController.UNIT_SCALE,
                    rectangleObject.getRectangle().y * LevelController.UNIT_SCALE);
            //Create body.
            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);

            //physicsBody.setUserData(LevelController.spriteSheet);   //sets user data.
            //Sets fixed rotation.
            //physicsBody.setFixedRotation(true);

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
            fixtureDefinition.density = 0.5f;


            //Attatch shape to physics body.
            physicsBody.createFixture(fixtureDefinition);
            rectangleShape.dispose();

        }
    }
}