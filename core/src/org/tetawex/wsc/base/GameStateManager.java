package org.tetawex.wsc.base;

import org.tetawex.wsc.base.util.Bundle;

/**
 * Created by tetawex on 04.09.17.
 */
public class GameStateManager<G extends BaseGame, GS> {
    private GS currentGameState;
    private BaseScreen<G> currentScreen;
    private GameStateSelector<G, GS> gameStateSelector;

    public GameStateManager(GameStateSelector<G, GS> gameStateSelector) {
        this.gameStateSelector = gameStateSelector;
        setState(Bundle.EMPTY, gameStateSelector.getDefaultState());
    }

    public void setState(Bundle bundle, GS gameState) {
        currentGameState = gameState;
        currentScreen = gameStateSelector.select(bundle, gameState);
    }

    public BaseScreen<G> getCurrentScreen() {
        return currentScreen;
    }

    public GS getCurrentGameState() {
        return currentGameState;
    }
}
