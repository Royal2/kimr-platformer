package com.kimr.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.kimr.platformer.controller.CameraController;
import com.kimr.platformer.controller.LevelController;
import com.kimr.platformer.controller.PlayerController;
import com.kimr.platformer.model.Player;

/**
 * Created by Student on 11/18/2014.
 */
public class GameScreen implements Screen {

    public GameScreen() {
        LevelController.initializeController();
        CameraController.initializeController();
        PlayerController.initializeController();
    }

    //render --> runs on every cpu tick.
    @Override
    public void render(float delta) {
        //sets game screen background color to clear.
        Gdx.gl.glClearColor(0.61f, 0.61f, 0.61f, 1f); //divided R,G,B by 255. Set fourth parameter to 1f for 100% opacity.
        //calls function to clear game screen.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update before Draw.
        //updates camera.
        CameraController.update();
        //updates game screen.
        LevelController.update();
        //updates player.
        PlayerController.update(delta);
        //draws on game screen.
        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        //resize window.
        CameraController.resize(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
