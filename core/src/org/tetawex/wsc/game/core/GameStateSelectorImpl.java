package org.tetawex.wsc.game.core;

import org.tetawex.wsc.base.BaseScreen;
import org.tetawex.wsc.base.GameStateSelector;
import org.tetawex.wsc.base.util.Bundle;

/**
 * Created by tetawex on 04.09.17.
 */
public class GameStateSelectorImpl implements GameStateSelector<WSCGame, GameState> {
    @Override
    public BaseScreen<WSCGame> select(Bundle bundle, GameState gameState) {
        return null;
    }

    @Override
    public GameState getDefaultState() {
        return GameState.LOADING;
    }
}
