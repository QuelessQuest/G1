package com.barrypress.wiz;

import com.BombingGames.WurfelEngine.Core.Controller;
import com.BombingGames.WurfelEngine.Core.Gameobjects.Selection;
import com.BombingGames.WurfelEngine.Core.Map.Point;
import com.badlogic.gdx.Gdx;

public class BoardController extends Controller {

    private Selection selectionEntity = new Selection();

    public BoardController() {
    }

    @Override
    public void init() {
        super.init();
        Gdx.app.log("BoardController", "Initializing");
        if (!selectionEntity.spawned()) selectionEntity.spawn(
                new Point(getMap(), 0, 0, getMap().getBlocksZ() - 1)
        );
    }
}
