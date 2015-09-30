package com.barrypress.wiz;

import com.BombingGames.WurfelEngine.Core.Controller;
import com.BombingGames.WurfelEngine.Core.Map.Point;
import com.BombingGames.WurfelEngine.WE;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BoardController extends Controller {

    public BoardController() {
    }

    @Override
    public void init() {
        super.init();
        Gdx.app.log("BoardController", "Initializing");
    }

    @Override
    public void onEnter(){
        super.onEnter();
        WE.CVARS.get("timespeed").setValue(0f);//stop the game time
        Gdx.app.debug("BoardController", "entered");
    }

    @Override
    public void exit(){
        Gdx.app.debug("BoardController", "exited");
    }

}
