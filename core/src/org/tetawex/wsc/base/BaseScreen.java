package org.tetawex.wsc.base;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by tetawex on 04.09.17.
 */
public abstract class BaseScreen<G extends BaseGame> implements Screen {
    private G game;
    private Stage stage;

    public BaseScreen(G game) {
        super();
        this.game = game;
        stage = new Stage();
        initUi();
    }
    public abstract void initUi();
    public G getGame() {
        return game;
    }

    public void setGame(G game) {
        this.game = game;
    }

    public String getLocalisedString(String code) {
        return getGame().getAssetProvider().getLocalisedString(code);
    }

    public abstract void onBackPressed();

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        stage.getViewport().getCamera().update();
    }


    @Override
    public void pause() {
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
    @Override
    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }
}
