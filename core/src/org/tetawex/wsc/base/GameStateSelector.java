package org.tetawex.wsc.base;

import org.tetawex.wsc.base.util.Bundle;

/**
 * Created by tetawex on 04.09.17.
 */
public interface GameStateSelector<T extends BaseGame, GS> {
    BaseScreen<T> select(Bundle bundle, GS gameState);

    GS getDefaultState();
}
