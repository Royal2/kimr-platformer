package com.kimr.platformer.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Student on 11/18/2014.
 */
public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        map = new TmxMapLoader().load("map/Level01.tmx");
        //adding map to renderer, renderer displays map in 2D, 1/70f defining number of units per pixels.
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        //setting size of camera, length + width. (14x14, map = square)
        camera = new OrthographicCamera(14f, 14f);
        //Set position of the camera (x,y,z). We only used the x and y axis because our game is 2D, not 3D.
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f); //Dividing the width and height by 2 to align the bottom left corner of the game to the bottom left corner of the window.
    }

    //render --> runs on every cpu tick.
    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        //updates camera if it moves.
        camera.update();
        //adjust frame to the camera.
        renderer.setView(camera);
        //drawing itself(the map).
        renderer.render();
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
