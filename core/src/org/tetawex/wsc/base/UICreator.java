package org.tetawex.wsc.base;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by tetawex on 09.09.17.
 */
public interface UICreator<AP extends BaseAssetProvider, S extends BaseScreen> {
    void create(AP assetProvider, Stage stage);
}
