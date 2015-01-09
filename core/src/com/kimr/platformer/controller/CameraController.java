package com.kimr.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by Student on 1/9/2015.
 */
public class CameraController {
    public static OrthographicCamera camera;

    public static void initializeController() {
        //store the width and height of the game screen into variables.
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        //setting size of camera, length + width. (14x14, map = square)
        //width*(height/width)=height.
        camera = new OrthographicCamera(14f, 14f * (height / width));   //multiplying the width of the game screen by the ratio of the height:width gives us a width that is equal to the height, resulting in a square.
        //Set position of the camera (x,y,z). We only used the x and y axis because our game is 2D, not 3D.
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f); //Dividing the width and height by 2 to align the bottom left corner of the game to the bottom left corner of the window.

    }

    public static void update() {
        //updates camera if it moves.
        camera.update();
    }

    public static void resize(int width, int height) {
        //resize window width to display 14 units.
        camera.viewportWidth = 14f;
        //resize window height to display to 14 units.
        camera.viewportHeight = 14f * height / width;   //aspect ratio.
        //updates camera to reflect the new changes.
        camera.update();
    }
}