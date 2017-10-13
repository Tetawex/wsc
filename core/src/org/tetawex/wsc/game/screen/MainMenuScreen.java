package org.tetawex.wsc.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import org.tetawex.wsc.base.BaseAssetProvider;
import org.tetawex.wsc.base.util.Bundle;
import org.tetawex.wsc.game.core.AssetProviderImpl;
import org.tetawex.wsc.game.core.GameState;
import org.tetawex.wsc.game.core.WSCGame;
import org.tetawex.wsc.game.util.StyleFactory;

/**
 * Created by tetawex on 09.09.17.
 */
public class MainMenuScreen extends BaseWSCScreen {
    private BaseAssetProvider.LoaderListener loaderListener;
    private ProgressBar progressBar;

    public MainMenuScreen(WSCGame game) {
        super(game);
    }

    @Override
    public void show() {
    }

    @Override
    public void initUi() {
        final Image background = new Image(getGame().getAssetProvider()
                .getTexture("backgrounds/background.png"));
        getStage().addActor(background);
    }

    @Override
    public void onBackPressed() {
        Gdx.app.exit();
    }
}
