package org.tetawex.wsc.game.core;

import org.tetawex.wsc.base.BaseScreen;
import org.tetawex.wsc.base.GameStateSelector;
import org.tetawex.wsc.base.util.Bundle;
import org.tetawex.wsc.game.screen.LoadingScreen;
import org.tetawex.wsc.game.screen.MainMenuScreen;

/**
 * Created by tetawex on 04.09.17.
 */
public class GameStateSelectorImpl implements GameStateSelector<WSCGame, GameState> {
    private WSCGame game;

    public GameStateSelectorImpl(WSCGame game) {
        this.game = game;
    }

    @Override
    public BaseScreen<WSCGame> select(Bundle bundle, GameState gameState) {
        switch (gameState){
            case LOADING:
                return new LoadingScreen(game);
            case MAIN_MENU:
                return new MainMenuScreen(game);
            default:
                return new MainMenuScreen(game);
        }
    }

    @Override
    public GameState getDefaultState() {
        return GameState.LOADING;
    }
}
