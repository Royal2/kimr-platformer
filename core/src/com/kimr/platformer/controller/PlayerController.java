package com.kimr.platformer.controller;

import com.badlogic.gdx.math.Vector2;
import com.kimr.platformer.model.Player;

/**
 * Created by Student on 1/9/2015.
 */
public class PlayerController {
    public static Player player;

    public static void initializeController() {
        player = new Player(new Vector2(3,3), 70, 100);
    }

    public static void update(float deltaTime) {
        //renders the players position on the map.
        player.update(deltaTime);
    }
}
