package org.tetawex.wsc.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import org.tetawex.wsc.base.BaseGame;
import org.tetawex.wsc.base.GameStateManager;

public class WSCGame extends BaseGame<AssetProviderImpl> {

    public WSCGame() {
        super(new AssetProviderImpl());
    }

    @Override
    public void create() {
        setGameStateManager(new GameStateManager<WSCGame, GameState>
                (this, new GameStateSelectorImpl(this)));
    }


    @Override
    public void dispose() {
        getGameStateManager().getCurrentScreen().dispose();
        getAssetProvider().dispose();
    }
}
