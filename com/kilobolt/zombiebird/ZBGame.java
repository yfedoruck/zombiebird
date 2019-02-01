package com.kilobolt.zombiebird;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.kilobolt.screens.GameScreen;
import com.kilobolt.zbhelpers.AssetLoader;

import java.io.IOException;

public class ZBGame extends Game {

    @Override
    public void create() {
        Gdx.app.log("ZBGame", "created");
        AssetLoader.load();
        setScreen(new GameScreen());
        ProcessBuilder pb = new ProcessBuilder("i3-msg", "[class=^ZombieBird$]", "floating", "enable");
        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dispose(){
        super.dispose();
        AssetLoader.dispose();
    }
}
