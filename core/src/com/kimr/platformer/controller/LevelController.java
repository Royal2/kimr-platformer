package com.kimr.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.kimr.platformer.model.Level;

/**
 * Created by Student on 1/9/2015.
 */
public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    public static World gameWorld;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController() {
        level = new Level("map/level01.tmx");
        //adding map to renderer, renderer displays map in 2D, 1/70f defining number of units per pixels.
        renderer = new OrthogonalTiledMapRenderer(Level.map, UNIT_SCALE);

        gameWorld = new World(new Vector2(0, -9.8f), true);   //Vector2 for gravity.
        debugRenderer = new Box2DDebugRenderer();   //Displays shapes.

        //this enables us to draw 2D object onto screen.
        spriteBatch = renderer.getSpriteBatch();
    }

    public static void draw() {
        //calls on spriteBatch to begin drawing.
        spriteBatch.begin();
        //uses spriteBatch object to draw the player.
        PlayerController.player.draw(spriteBatch);
        //ends spriteBatch.
        spriteBatch.end();

        //renders game world.
        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update() {
        //adjust frame to the camera.
        renderer.setView(CameraController.camera);
        //drawing itself(the map).
        renderer.render();
        //updating gameWorld.
        gameWorld.step(1/60f, 1, 1); //update 60 frames per sec.
    }
}