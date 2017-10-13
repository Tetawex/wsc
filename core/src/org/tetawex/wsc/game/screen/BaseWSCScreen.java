package org.tetawex.wsc.game.screen;

import org.tetawex.wsc.base.BaseScreen;
import org.tetawex.wsc.base.util.Bundle;
import org.tetawex.wsc.game.core.GameState;
import org.tetawex.wsc.game.core.WSCGame;

/**
 * Created by Tetawex on 15.09.2017.
 */
public abstract class BaseWSCScreen extends BaseScreen<WSCGame> {
    public BaseWSCScreen(WSCGame game) {
        super(game);
    }

    public void setGameState(Bundle bundle, GameState gameState) {
        getGame().getGameStateManager().setState(bundle, gameState);
    }

    @Override
    public void onBackPressed() {

    }
}
