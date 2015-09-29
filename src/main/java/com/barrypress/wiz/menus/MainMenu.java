package com.barrypress.wiz.menus;

import com.BombingGames.WurfelEngine.Core.AbstractMainMenu;

public class MainMenu extends AbstractMainMenu {

    private static MenuView view;
    private static MenuController controller;
    private MenuItem[] menuItems;
    private boolean warning = true;

    /**
     * Use this constructor to pass your controller and views in order of the main menu
     *
     * @param menuItems
     */
    public MainMenu(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }


    @Override
    public void init() {
        controller = new MenuController(menuItems);
        view = new MenuView(controller);
    }

    @Override
    public void renderImpl(float dt) {
        controller.update(dt);
        view.update(dt);
        view.render(warning);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        controller.show();
        view.show();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    /**
     * @return
     */
    public static MenuController getController() {
        return controller;
    }

    /**
     * @return
     */
    public static MenuView getView() {
        return view;
    }

    /**
     * If you want to hide the warning message call this method.
     */
    public void supressWarning() {
        warning = false;
    }

}
