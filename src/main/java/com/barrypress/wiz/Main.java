package com.barrypress.wiz;

import com.BombingGames.WurfelEngine.Core.Gameobjects.CoreData;
import com.barrypress.wiz.tile.Square;

public class Main {

    public static void main(String[] args) {

        CoreData.setCustomBlockFactory(new Square());
        BoardState boardState = new BoardState();
        boardState.loadTiles();
    }

}