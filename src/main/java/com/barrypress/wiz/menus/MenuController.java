package com.barrypress.wiz.menus;

import com.badlogic.gdx.Gdx;

public class MenuController {
    private final MenuItem[] menuItems;

    /**
     * Creates a new Controller
     *
     * @param menuItems
     */
    public MenuController(MenuItem[] menuItems) {
        this.menuItems = menuItems;
        MenuItem.setSound(Gdx.audio.newSound(Gdx.files.internal("com/BombingGames/WurfelEngine/Core/BasicMainMenu/click2.wav")));
    }

    /**
     * updates screen logic
     *
     * @param dt
     */
    public void update(float dt) {
        for (MenuItem basicMenuItem : menuItems) {
            if (basicMenuItem.isClicked()) basicMenuItem.action();
        }
    }

    /**
     *
     */
    public void show() {

    }

    /**
     * @return
     */
    public MenuItem[] getMenuItems() {
        return menuItems;
    }

}