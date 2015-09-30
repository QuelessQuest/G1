package com.barrypress.wiz;

import com.BombingGames.WurfelEngine.Core.Gameobjects.CoreData;
import com.BombingGames.WurfelEngine.WE;
import com.barrypress.wiz.map.Square;
import com.barrypress.wiz.menus.MainMenu;
import com.barrypress.wiz.menus.MenuItem;

public class Main {

    public static void main(String[] args) {

        CoreData.setCustomBlockFactory(new Square());
        //BoardState boardState = new BoardState();
        //boardState.loadTiles();

        MenuItem[] menuItems = new MenuItem[]{
                new MenuItem(0, "Start", BoardController.class, BoardView.class),
                new MenuItem(1, "Options"),
                new MenuItem(2, "Exit")
        };

        String[] myArgs = { "-windowed" };
        WE.setMainMenu(new MainMenu(menuItems));
        WE.launch("G1", myArgs);
    }
}