package com.barrypress.wiz;

import com.BombingGames.WurfelEngine.Core.Camera;
import com.BombingGames.WurfelEngine.Core.Controller;
import com.BombingGames.WurfelEngine.Core.GameView;
import com.BombingGames.WurfelEngine.WE;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.barrypress.wiz.menus.Toolbar;

public class BoardView extends GameView {

    private BoardController controller;

    private Toolbar systemTools;

    private Camera camera;
    private float cameraSpeed = 0.5f;

    private Vector2 cameraMove = new Vector2();

    @Override
    public void init(Controller controller) {
        super.init(controller);
        Gdx.app.debug("BoardView", "Initializing");
        this.controller = (BoardController) controller;

        // TODO - Temp Borders
        ShapeRenderer sh = WE.getEngineView().getShapeRenderer();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glLineWidth(3);

        sh.begin(ShapeRenderer.ShapeType.Line);

        int rightborder = Gdx.graphics.getWidth();
        int bottomBorder = Gdx.graphics.getHeight();

        sh.setColor(Color.GRAY.cpy().sub(0, 0, 0, 0.5f));

        sh.line(0, 620, rightborder, 620);
        sh.line(1150, 0, 1150, bottomBorder);
        //"shadow"
        sh.setColor(Color.DARK_GRAY.cpy().sub(0, 0, 0, 0.5f));
        sh.line(0, 623, rightborder, 623);
        sh.line(1153, 0, 1153, bottomBorder);

        sh.end();
        Gdx.gl.glLineWidth(1);
        Gdx.gl.glDisable(GL20.GL_BLEND);
        // TODO - End Tmp Borders

        /*
        Gdx.gl20.glClearColor(1f, 1f, 1f, 1f); //102,109,109
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        SpriteBatch batch = new SpriteBatch();

        Sprite pcFrame1 = new Sprite(new Texture(Gdx.files.internal("src/main/java/com/barrypress/wiz/assets/pc_circle.png")));
        pcFrame1.setX(10);
        pcFrame1.setY(10);

        batch.begin();
        pcFrame1.draw(batch);
        batch.end();
        */

        addCamera(camera = new Camera(0, 0, Gdx.graphics.getWidth(), Gdx

                .graphics.getHeight(), this));
    /*
            leftColorGUI = new PlacableGUI(getStage(), this.controller.getSelectionEntity(), true);
            getStage().addActor(leftColorGUI);
            leftSelector = new PlacableSelector(leftColorGUI, true);
            getStage().addActor(leftSelector);

            rightColorGUI = new PlacableGUI(getStage(), this.controller.getSelectionEntity(), false);
            getStage().addActor(rightColorGUI);
            rightSelector = new PlacableSelector(rightColorGUI, false);
            getStage().addActor(rightSelector);
    */
        //setup GUI
        TextureAtlas spriteSheet = WE.getAsset("src/main/java/com/barrypress/wiz/assets/tools.txt");
/*
        //add play button
        final Image playbutton = new Image(spritesheet.findRegion("play_button"));
        playbutton.setX(Gdx.graphics.getWidth()-40);
        playbutton.setY(Gdx.graphics.getHeight()-40);
        playbutton.addListener(new PlayButton(controller, false));
        getStage().addActor(playbutton);

        //add load button
        final Image loadbutton = new Image(spritesheet.findRegion("load_button"));
        loadbutton.setX(Gdx.graphics.getWidth()-80);
        loadbutton.setY(Gdx.graphics.getHeight()-40);
        loadbutton.addListener(new LoadButton(this,controller));
        getStage().addActor(loadbutton);

        //add save button
        final Image savebutton = new Image(spritesheet.findRegion("save_button"));
        savebutton.setX(Gdx.graphics.getWidth()-120);
        savebutton.setY(Gdx.graphics.getHeight()-40);
        savebutton.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                Controller.getMap().save(Controller.getMap().getCurrentSaveSlot());
            }
        });
        getStage().addActor(savebutton);

        //add replaybutton
        final Image replaybutton = new Image(spritesheet.findRegion("replay_button"));
        replaybutton.setX(Gdx.graphics.getWidth()-160);
        replaybutton.setY(Gdx.graphics.getHeight()-40);
        replaybutton.addListener(new PlayButton(controller, true));
        getStage().addActor(replaybutton);

        if (Controller.getLightEngine() != null)
            Controller.getLightEngine().setToNoon();
*/
        systemTools = new

                Toolbar(getStage(), spriteSheet

        );

        getStage()

                .

                        addActor(systemTools);

    }

    protected void setCameraSpeed(float speed) {
        cameraSpeed = speed;
    }

    protected void setCameraMoveVector(float x, float y) {
        cameraMove.x = x;
        cameraMove.y = y;
    }

    protected Vector2 getCameraMoveVector() {
        return cameraMove;
    }

    @Override
    public void render() {
        super.render();

        systemTools.render(WE.getEngineView().getShapeRenderer());
    }

    @Override
    public void update(final float dt) {
        super.update(dt);

        if (camera != null) {
            float rdt = Gdx.graphics.getRawDeltaTime() * 1000f;//use "scree"-game time
            camera.move((int) (cameraMove.x * cameraSpeed * rdt), (int) (cameraMove.y * cameraSpeed * rdt));
        }
    }


}
