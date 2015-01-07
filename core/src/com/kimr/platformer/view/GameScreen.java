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
import com.kimr.platformer.model.Player;

/**
 * Created by Student on 11/18/2014.
 */
public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public Batch spriteBatch;
    public Player player;

    public static World gameWorld;
    private Box2DDebugRenderer debugRenderer;

    public GameScreen() {
        map = new TmxMapLoader().load("map/Level01.tmx");
        //adding map to renderer, renderer displays map in 2D, 1/70f defining number of units per pixels.
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);

        gameWorld = new World(new Vector2(0, -9.8f), true);   //Vector2 for gravity.
        debugRenderer = new Box2DDebugRenderer();   //Displays shapes.

        //store the width and height of the game screen into variables.
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        //setting size of camera, length + width. (14x14, map = square)
        //width*(height/width)=height.
        camera = new OrthographicCamera(14f, 14f * (height / width));   //multiplying the width of the game screen by the ratio of the height:width gives us a width that is equal to the height, resulting in a square.
        //Set position of the camera (x,y,z). We only used the x and y axis because our game is 2D, not 3D.
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f); //Dividing the width and height by 2 to align the bottom left corner of the game to the bottom left corner of the window.

        //this enables us to draw 2D object onto screen.
        spriteBatch = renderer.getSpriteBatch();
        player = new Player();
    }

    //render --> runs on every cpu tick.
    @Override
    public void render(float delta) {
        //sets game screen background color to clear.
        Gdx.gl.glClearColor(0.61f, 0.61f, 0.61f, 1f); //divided R,G,B by 255. Set fourth parameter to 1f for 100% opacity.
        //calls function to clear game screen.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //updates camera if it moves.
        camera.update();
        //adjust frame to the camera.
        renderer.setView(camera);
        //drawing itself(the map).
        renderer.render();

        //renders the players position on the map.
        player.update(delta);

        //calls on spriteBatch to begin drawing.
        spriteBatch.begin();
        //uses spriteBatch object to draw the player.
        player.draw(spriteBatch);
        //ends spriteBatch.
        spriteBatch.end();
        //renders gravity.
        debugRenderer.render(gameWorld, camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        //resize window width to display 14 units.
        camera.viewportWidth = 14f;
        //resize window height to display to 14 units.
        camera.viewportHeight = 14f * height / width;   //aspect ratio.
        //updates camera to reflect the new changes.
        camera.update();
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
