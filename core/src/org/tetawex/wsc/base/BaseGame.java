package org.tetawex.wsc.base;

import com.badlogic.gdx.Game;

/**
 * Created by tetawex on 04.09.17.
 */
public class BaseGame<AP extends BaseAssetProvider> extends Game {
    private GameStateManager gameStateManager;
    private AP assetProvider;

    public BaseGame(GameStateManager gameStateManager, AP assetProvider) {
        this.gameStateManager = gameStateManager;
        this.assetProvider = assetProvider;
    }
    @Override
    public void create() {
    }

    @Override
    public void render() {

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
