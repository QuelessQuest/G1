package com.barrypress.wiz.screens;
/**
 * This class is public domain.
 */

import com.BombingGames.WurfelEngine.Core.Loading.LoadingScreen;
import com.BombingGames.WurfelEngine.WE;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.barrypress.wiz.object.AbstractGameObject;

/**
 * Class under public domain. Modified for own needs. This class renders is the default loading screen of wurfel engine.
 * @author Mats Svensson, Benedikt Vogler
 */
public class DDLoadingScreen extends LoadingScreen {

    private Stage stage;

    private Image logo;
    private Image loadingFrame;
    private Image loadingBarHidden;
    private Image screenBg;
    private Image loadingBg;

    private float startX, endX;

    private Actor loadingBar;
    private float percent;

    /**
     *To load custom files overwrite #customLoading
     */
    public DDLoadingScreen() {
        Gdx.app.log("DDLoadingScreen", "Initializing");
        AssetManager manager = WE.getAssetManager();

        // Tell the manager to load assets for the loading screen
        manager.load("src/main/java/com/barrypress/wiz/screens/loading.txt", TextureAtlas.class);
        manager.finishLoading();

        manager.load(AbstractGameObject.getSpritesheetPath()+".txt", TextureAtlas.class);
        manager.load("src/main/java/com/barrypress/wiz/assets/tools.txt", TextureAtlas.class);


        manager.load("com/BombingGames/WurfelEngine/Core/images/bloodblur.png", Texture.class);

        // manager.load("com/BombingGames/WurfelEngine/Game/Blockimages/Spritesheet.png", Pixmap.class);
        manager.load("com/BombingGames/WurfelEngine/Core/SoundEngine/Sounds/wind.ogg", Sound.class);
        manager.load("com/BombingGames/WurfelEngine/Core/SoundEngine/Sounds/landing.wav", Sound.class);
        manager.load("com/BombingGames/WurfelEngine/Core/SoundEngine/Sounds/splash.wav", Sound.class);
        manager.load("com/BombingGames/WurfelEngine/Core/SoundEngine/Sounds/explosion2.wav", Sound.class);
        //manager.load("com/BombingGames/WurfelEngine/Core/arial.fnt", BitmapFont.class);

        //load files from configRef
        customLoading(manager);
    }
    /**
     * override and add items via {@link AssetManager#load(java.lang.String, java.lang.Class)}
     * @param manager
     */
    public void customLoading(AssetManager manager){
    }



    @Override
    public void show() {
        // Initialize the stage where we will place everything
        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), WE.getEngineView().getBatch());

        // Get our textureatlas from the manager
        TextureAtlas GUItexture = WE.getAsset("src/main/java/com/barrypress/wiz/screens/loading.txt");
        // Grab the regions from the atlas and create some images
        logo = new Image(GUItexture.findRegion("banner_medium"));
        loadingFrame = new Image(GUItexture.findRegion("loading-frame"));
        loadingBarHidden = new Image(GUItexture.findRegion("loading-bar-hidden"));
        screenBg = new Image(GUItexture.findRegion("screen-bg"));
        loadingBg = new Image(GUItexture.findRegion("loading-frame-bg"));

        // Add the loading bar animation
        TextureAtlas.AtlasRegion[] anitextures = new TextureAtlas.AtlasRegion[3];
        anitextures[0] = GUItexture.findRegion("loading_bar1");
        anitextures[1] = GUItexture.findRegion("loading_bar2");
        anitextures[2] = GUItexture.findRegion("loading_bar3");

        Animation anim = new Animation(0.2f, anitextures);
        anim.setPlayMode(Animation.PlayMode.LOOP_REVERSED);
        loadingBar = new LoadingBar(anim);

        // Or if you only need a static bar, you can do
        // loadingBar = new Image(atlas.findRegion("loading-bar1"));

        // Add all the actors to the stage
        stage.addActor(screenBg);
        stage.addActor(loadingBar);
        stage.addActor(loadingBg);
        stage.addActor(loadingBarHidden);
        stage.addActor(loadingFrame);
        stage.addActor(logo);
    }

    @Override
    public void resize(int width, int height) {
        // Set our screen to always be WWW x 480 in size
        //width = 1920;
        //height = 1080;
        //stage.setViewport(new StretchViewport(width , height));

        // Make the background fill the screen
        screenBg.setSize(width, height);

        // Place the logo in the middle of the screen and 100 px up
        logo.setX((width - logo.getWidth()) / 2);
        logo.setY((height - logo.getHeight()) / 2 + 100);

        // Place the loading frame in the middle of the screen
        loadingFrame.setX((stage.getWidth() - loadingFrame.getWidth()) / 2);
        loadingFrame.setY((stage.getHeight() - loadingFrame.getHeight()) / 2);

        // Place the loading bar at the same spot as the frame, adjusted a few px
        loadingBar.setX(loadingFrame.getX() + 15);
        loadingBar.setY(loadingFrame.getY() + 5);

        // Place the image that will hide the bar on top of the bar, adjusted a few px
        loadingBarHidden.setX(loadingBar.getX() + 35);
        loadingBarHidden.setY(loadingBar.getY() - 3);
        // The start position and how far to move the hidden loading bar
        startX = loadingBarHidden.getX();
        endX = 440;

        // The rest of the hidden bar
        loadingBg.setSize(450, 50);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setY(loadingBarHidden.getY() + 3);
    }

    @Override
    public void renderImpl(float dt) {
        if (WE.getAssetManager().update()) { // Load some, will return true if done loading
            Gdx.app.log("Loading", "finished");
            WE.startGame();
        }

        // Interpolate the percentage to make it more smooth
        percent = Interpolation.linear.apply(percent, WE.getAssetManager().getProgress(), 0.5f);

        // Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update positions (and size) to match the percentage
        loadingBarHidden.setX(startX + endX * percent);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setWidth(450 - 450 * percent);
        loadingBg.invalidate();

        // Show the loading screen
        stage.act();
        stage.draw();
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
        Gdx.app.debug("DDLoadingScreen", "disposing");
        // Dispose the loading assets as we no longer need them
        stage.dispose();
        WE.getAssetManager().unload("com/barrypress/wiz/screens/loading.txt");//causes programm to stop and show a white screen!
    }
}

