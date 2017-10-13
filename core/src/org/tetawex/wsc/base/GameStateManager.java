package org.tetawex.wsc.base;

import com.badlogic.gdx.Game;
import org.tetawex.wsc.base.util.Bundle;
import org.tetawex.wsc.base.util.ImmutableBundle;

/**
 * Created by tetawex on 04.09.17.
 */
public class GameStateManager<G extends BaseGame, GS> {
    private G game;
    private GS currentGameState;
    private BaseScreen<G> currentScreen;
    private GameStateSelector<G, GS> gameStateSelector;

    public GameStateManager(G game, GameStateSelector<G, GS> gameStateSelector) {
        this.game = game;
        this.gameStateSelector = gameStateSelector;
        setState(ImmutableBundle.get(), gameStateSelector.getDefaultState());
    }

    public void setState(Bundle bundle, GS gameState) {
        currentGameState = gameState;
        currentScreen = gameStateSelector.select(bundle, gameState);
        game.setScreen(currentScreen);
    }

    public BaseScreen<G> getCurrentScreen() {
        return currentScreen;
    }

    public GS getCurrentGameState() {
        return currentGameState;
    }
}
