package org.tetawex.wsc.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import org.tetawex.wsc.base.BaseAssetProvider;
import org.tetawex.wsc.base.BaseScreen;
import org.tetawex.wsc.game.core.AssetProviderImpl;
import org.tetawex.wsc.game.core.WSCGame;
import org.tetawex.wsc.game.util.StyleFactory;

/**
 * Created by tetawex on 09.09.17.
 */
public class LoadingScreen extends BaseScreen<WSCGame> {
    BaseAssetProvider.LoaderListener loaderListener;
    AssetProviderImpl assetProvider;

    public LoadingScreen(WSCGame game) {
        super(game);
        assetProvider = getGame().getAssetProvider();
    }

    @Override
    public void show() {
        assetProvider.startLoading();
        getStage().addActor(new Actor() {
            @Override
            public void act(float delta) {
                assetProvider.update();
            }
        });
    }

    @Override
    public void initUi() {
        final Image background = new Image(getGame().getAssetProvider()
                .getTexture("backgrounds/background.png"));
        background.setFillParent(true);
        Table table = new Table();
        table.add(new ProgressBar(0f, 1f, 0.001f, false,
                StyleFactory.generateLoadingMenuProgressBarStyle(assetProvider)))
        .growX().pad(40f);
        loaderListener = new BaseAssetProvider.LoaderListener() {
            @Override
            public void progressChanged(float newProgress) {

            }

            @Override
            public void loadFinished() {

            }
        };
        assetProvider.setLoaderListener(loaderListener);
    }

    @Override
    public void onBackPressed() {
        Gdx.app.exit();
    }
}
