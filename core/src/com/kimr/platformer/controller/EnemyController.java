package com.kimr.platformer.controller;

import com.badlogic.gdx.math.Vector2;
import com.kimr.platformer.model.Enemy;

/**
 * Created by Student on 1/15/2015.
 */
public class EnemyController {
    public static Enemy enemy;

    public static void initializeController() {
        enemy = new Enemy(new Vector2(2,3), (102/2), (116/2), "img/enemy-barnacle.png");
    }
    public static void update(float deltaTime) {
        //renders the players position on the map.
        enemy.update(deltaTime);
    }
}