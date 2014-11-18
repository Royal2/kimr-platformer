package com.kimr.platformer;

import com.badlogic.gdx.Game;
import com.kimr.platformer.view.GameScreen;

public class Platformer extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
