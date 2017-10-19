package org.tetawex.wsc.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import org.tetawex.wsc.base.BaseAssetProvider;
import org.tetawex.wsc.base.util.ImmutableBundle;
import org.tetawex.wsc.game.core.AssetProviderImpl;
import org.tetawex.wsc.game.core.GameState;
import org.tetawex.wsc.game.core.WSCGame;
import org.tetawex.wsc.game.util.StyleFactory;

/**
 * Created by tetawex on 09.09.17.
 */
public class LoadingScreen extends BaseWSCScreen {
    private AssetProviderImpl assetProvider;
    private ProgressBar progressBar;

    public LoadingScreen(WSCGame game) {
        super(game);
        assetProvider = getGame().getAssetProvider();
        assetProvider.preLoad();
    }

    @Override
    public void show() {
        super.show();
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
        Stack stack = new Stack();
        getStage().addActor(stack);
        final Image background = new Image(getGame().getAssetProvider()
                .getPreAssetManager().get("backgrounds/background_loading.png", Texture.class));
        background.setFillParent(true);
        //stack.addActor(background);
        stack.setFillParent(true);

        Table table = new Table();
        table.setFillParent(true);
        stack.add(table);

        table.row().grow();

        progressBar = new ProgressBar(0f, 1f, 0.01f, false,
                StyleFactory.generateLoadingMenuProgressBarStyle(assetProvider));
        progressBar.setVisualInterpolation(new Interpolation.Pow(8));
        progressBar.setAnimateDuration(0.5f);
        table.add(progressBar).height(120f).bottom()
                .growX().pad(50f);

        assetProvider.setLoaderListener(new BaseAssetProvider.LoaderListener() {
            @Override
            public void progressChanged(float newProgress) {
                progressBar.setValue(newProgress);
            }

            @Override
            public void loadFinished() {
                setGameState(ImmutableBundle.get(), GameState.MAIN_MENU);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Gdx.app.exit();
    }
}
