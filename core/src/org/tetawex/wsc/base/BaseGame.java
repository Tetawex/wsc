package org.tetawex.wsc.base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by tetawex on 04.09.17.
 */
public class BaseGame<AP extends BaseAssetProvider> extends Game {
    private GameStateManager gameStateManager;
    private AP assetProvider;

    public BaseGame(AP assetProvider) {
        this.assetProvider = assetProvider;
    }

    public void setGameStateManager(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    @Override
    public void create() {
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        getGameStateManager().getCurrentScreen().render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public AP getAssetProvider() {
        return assetProvider;
    }
}
