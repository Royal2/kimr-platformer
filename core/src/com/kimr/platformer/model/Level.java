package com.kimr.platformer.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
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
    //Gets mapLayers.
    public MapLayer getMapLayer (String layerName) {
        return map.getLayers().get(layerName);

    }
    //Gets objects found in mapLayer.
    public MapObjects getMapObjects(MapLayer mapLayer) {
        return mapLayer.getObjects();
    }
}
