package org.tetawex.wsc.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.tetawex.wsc.base.BaseAssetProvider;
import org.tetawex.wsc.base.BaseGame;
import org.tetawex.wsc.base.GameStateManager;

public class WSCGame extends BaseGame<AssetProviderImpl> {

    public WSCGame() {
        super(new GameStateManager<WSCGame, GameState>(new GameStateSelectorImpl()),
                new AssetProviderImpl());
    }

    @Override
    public void create() {
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
        getAssetProvider().dispose();
    }
}
