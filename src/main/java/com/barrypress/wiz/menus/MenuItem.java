package com.barrypress.wiz.menus;

import com.BombingGames.WurfelEngine.Core.BasicMainMenu.BasicOptionsScreen;
import com.BombingGames.WurfelEngine.Core.Controller;
import com.BombingGames.WurfelEngine.Core.GameView;
import com.BombingGames.WurfelEngine.Core.Loading.LoadingScreen;
import com.BombingGames.WurfelEngine.WE;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuItem {
    private static Sound sound;
    private static int highlight = 0;
    private final Class<? extends Controller> gameController;
    private final Class<? extends GameView> gameView;
    private int x;
    private int y;
    private final int index;
    private final String label;
    private final int width;
    private final int height = 50;

    /**
     * Create a new menu Item which can launch a game.
     *
     * @param index          the index of the button
     * @param label          the string displayed by the button. If "exit" or "options" they change their behaviour.
     * @param gameController Your game controller class for this menu item
     * @param gameView       Your game view class for this menu item
     */
    public MenuItem(int index, String label, Class<? extends Controller> gameController, Class<? extends GameView> gameView) {
        this.gameController = gameController;
        this.gameView = gameView;
        this.index = index;
        this.label = label;
        this.width = this.label.length() * 20;
    }

    /**
     * Create a new menu Item which does something specific like exiting or showing the option screen.
     *
     * @param index the index of the button
     * @param label the string displayed by the button. If "exit" or "options" they cahnge they behaviour.
     */
    public MenuItem(int index, String label) {
        this.gameController = null;
        this.gameView = null;
        this.index = index;
        this.label = label;
        this.width = this.label.length() * 20;
    }

    /**
     * Renders the menu item.
     *
     * @param batch
     * @param sprite
     */
    public void render(SpriteBatch batch, Sprite sprite) {
        this.x = Math.round(Gdx.graphics.getWidth() - sprite.getWidth()) / 2;
        this.y = (Gdx.graphics.getHeight() / 2 + 120 - index * 80);

        sprite.setX((Gdx.graphics.getWidth() - sprite.getWidth()) / 2);
        sprite.setY(this.y);
        sprite.draw(batch);
    }


    /**
     * Check if the mouse clicked the menuItem.
     *
     * @return
     */
    public boolean isClicked() {
        int mouseX = Gdx.input.getX();
        int mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

        return (
                Gdx.input.isButtonPressed(Input.Buttons.LEFT) &&
                        (mouseX >= x && mouseX <= x + width) &&
                        (mouseY >= y && mouseY <= y + height)
        );
    }

    /**
     * @return
     */
    public Class<? extends Controller> getGameController() {
        return gameController;
    }

    /**
     * @return
     */
    public Class<? extends GameView> getGameView() {
        return gameView;
    }

    /**
     *
     */
    public void action() {
        if (sound != null)
            sound.play();

        if (label.equalsIgnoreCase("exit")) {
            Gdx.app.exit();
        } else if (label.equalsIgnoreCase("options")) {
            WE.setScreen(new BasicOptionsScreen());
        } else {
            try {
                Controller c = getGameController().newInstance();
                GameView v = getGameView().newInstance();
                WE.initAndStartGame(c, v, new LoadingScreen());
            } catch (InstantiationException ex) {
                Gdx.app.error("MenuItem", "Failed initialising game by creating new instances of a class.");
                Logger.getLogger(MenuItem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Gdx.app.error("MenuItem", "Failed initialising game.");
                Logger.getLogger(MenuItem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @param sound
     */
    public static void setSound(Sound sound) {
        MenuItem.sound = sound;
    }

    /**
     * @return
     */
    public static int getHighlight() {
        return highlight;
    }

    /**
     * @param highlight
     */
    public static void setHighlight(int highlight) {
        MenuItem.highlight = highlight;
    }

    public String getLabel() { return label; }
}