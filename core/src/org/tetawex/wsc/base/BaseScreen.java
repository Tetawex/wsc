package org.tetawex.wsc.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import org.tetawex.wsc.base.util.Bundle;
import org.tetawex.wsc.base.util.ImmutableBundle;

/**
 * Created by tetawex on 04.09.17.
 */
public abstract class BaseScreen<G extends BaseGame> implements Screen {
    private G game;
    private Stage stage;
    private Bundle bundle;

    public BaseScreen(G game, Bundle bundle) {
        super();
        this.game = game;
        this.bundle = bundle;

        Camera camera = new OrthographicCamera(2560f, 1440f);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0f);
        stage = new Stage(new ExtendViewport(2560f, 1440f, camera));
        Gdx.input.setInputProcessor(stage);
    }

    public BaseScreen(G game) {
        this(game, ImmutableBundle.get());
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
        initUi();
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

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }
}
