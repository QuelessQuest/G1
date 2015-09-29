package com.barrypress.wiz.menus;

import com.BombingGames.WurfelEngine.Core.BasicMainMenu.BasicMenuItem;
import com.BombingGames.WurfelEngine.WE;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * The View manages the graphical ouput and input.
 *
 * @author Benedikt
 */
public class MenuView {
    private final Sprite lettering;
    private final SpriteBatch batch;
    private final BitmapFont font;
    private float alpha = 0;
    private final ShapeRenderer sr;
    private final MenuController controller;

    /**
     * Creates alpha View.
     *
     * @param controller
     */
    protected MenuView(MenuController controller) {
        this.controller = controller;
        //load textures
        lettering = new Sprite(new Texture(Gdx.files.internal("src/main/java/com/barrypress/wiz/assets/Lettering.png")));
        lettering.setX((Gdx.graphics.getWidth() - lettering.getWidth()) / 2);
        lettering.setY(Gdx.graphics.getHeight() - 150);

        batch = new SpriteBatch();

        font = new BitmapFont();
        font.setColor(236/255f, 225/255f, 121/255f, 1f); // 236,225,121 font.setColor(Color.WHITE);

        sr = new ShapeRenderer();
    }

    /**
     * @param dt time in ms
     */
    protected void update(float dt) {
        alpha += dt / 1000f;
        if (alpha > 1) alpha = 1;
    }

    /**
     * renders the scene
     *
     * @param warning Render alpha warning about no custom main menu in use.
     */
    protected void render(boolean warning) {
        //clear & set background to black
        Gdx.gl20.glClearColor(102/255f, 109/255f, 109/255f, 1f); //102,109,109
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // render the lettering
        batch.begin();
        lettering.draw(batch);

        // Draw the menu items
        for (MenuItem mI : MainMenu.getController().getMenuItems()) {
            String button = "src/main/java/com/barrypress/wiz/assets/" + mI.getLabel() + ".png";
            Sprite spriteButton = new Sprite(new Texture(Gdx.files.internal(button)));
            mI.render(batch, spriteButton);
        }

        batch.end();
    }

    /**
     *
     */
    protected void show() {
        Pixmap cursor = new Pixmap(Gdx.files.internal("com/BombingGames/WurfelEngine/Core/images/wecursor.png"));
        Gdx.input.setCursorImage(cursor, 0, 0);

        WE.getEngineView().addInputProcessor(new InputListener(controller));
    }

    private class InputListener implements InputProcessor {
        private final MenuController controller;

        InputListener(MenuController controller) {
            this.controller = controller;
        }


        @Override
        public boolean keyDown(int keycode) {
            if (keycode == Input.Keys.ESCAPE)
                Gdx.app.exit();
            if (keycode == Input.Keys.DOWN && MenuItem.getHighlight() < controller.getMenuItems().length - 1)
                MenuItem.setHighlight(MenuItem.getHighlight() + 1);
            if (keycode == Input.Keys.UP && MenuItem.getHighlight() > 0)
                MenuItem.setHighlight(MenuItem.getHighlight() - 1);
            if (keycode == Input.Keys.ENTER)
                controller.getMenuItems()[MenuItem.getHighlight()].action();
            return true;
        }

        @Override
        public boolean keyUp(int keycode) {
            return true;
        }

        @Override
        public boolean keyTyped(char character) {
            return true;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            return true;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            return true;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return true;
        }

        @Override
        public boolean scrolled(int amount) {
            return true;
        }
    }

}
