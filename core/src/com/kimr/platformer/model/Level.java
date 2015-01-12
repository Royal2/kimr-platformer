package com.kimr.platformer.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * Created by Student on 1/12/2015.
 */
public class Level {
    public static TiledMap map;

    public Level(String mapPath){
        //Loads level map.
        map = new TmxMapLoader().load(mapPath);

    }
}
