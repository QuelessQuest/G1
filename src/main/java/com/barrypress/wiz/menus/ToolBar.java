package com.barrypress.wiz.menus;

import com.BombingGames.WurfelEngine.WE;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

/**
 * A toolbar for the editor.
 *
 * @author Benedikt Vogler
 */
public class Toolbar extends Window {

    /**
     * a enum listing the available tools
     */
    public enum Tool {
        LOAD(0, "load_button"),
        SAVE(1, "save_button"),
        EXIT(2, "exit_button");

        private int id;
        private String name;

        Tool(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }
    }

    private int leftPos;
    private int bottomPos;

    private final Image[] items = new Image[Tool.values().length];

    /**
     * creates a new toolbar
     *
     * @param stage
     * @param sprites
     */
    public Toolbar(Stage stage, TextureAtlas sprites) {
        super("Tools", WE.getEngineView().getSkin());
        leftPos = (int) (stage.getWidth() / 2 - items.length * 50 / 2);
        bottomPos = (int) (stage.getHeight() - 100);

        setPosition(leftPos, bottomPos);
        setWidth(Tool.values().length * 25);
        setHeight(45);

        for (int i = 0; i < items.length; i++) {
            items[Tool.values()[i].id] = new Image(sprites.findRegion(Tool.values()[i].name));
            items[i].setPosition(i * 25, 2);
            //items[i].addListener(new ToolSelectionListener(Tool.values()[i], left, right));
            addActor(items[i]);
        }
    }

    public void render(ShapeRenderer shR) {
        shR.translate(getX(), getY(), 0);
        shR.begin(ShapeRenderer.ShapeType.Line);
        //draw left
        shR.setColor(Color.GREEN);
        shR.rect(items[Tool.LOAD.getId()].getX() - 1, items[Tool.LOAD.getId()].getY() - 1, 22, 22);
        //draw right
        shR.setColor(Color.BLUE);
        shR.rect(items[Tool.EXIT.getId()].getX() - 2, items[Tool.EXIT.getId()].getY() - 2, 24, 24);

        shR.end();
        shR.translate(-getX(), -getY(), 0);
    }
/*
    //class to detect clicks
    private class ToolSelectionListener extends InputListener {

        private final Tool tool;
        private final PlacableSelector left;
        private final PlacableSelector right;

        ToolSelectionListener(Tool tool, PlacableSelector left, PlacableSelector right) {
            this.tool = tool;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            if (button == Input.Buttons.LEFT) {
                selectionLeft = tool;
                if (tool.selectFromBlocks) { //show entities on left
                    left.showBlocks();
                } else {//show blocks on left
                    if (tool.selectFromEntities) {
                        left.showEntities();
                    } else {
                        left.hide(true);
                    }
                }
            } else if (button == Input.Buttons.RIGHT) {
                selectionRight = tool;
                if (tool.selectFromBlocks) { //show entities on left
                    right.showBlocks();
                } else { //show blocks on left
                    if (tool.selectFromEntities) {
                        right.showEntities();
                    } else {
                        right.hide(true);
                    }
                }
            }

            return true;
        }

    }
    */
}

