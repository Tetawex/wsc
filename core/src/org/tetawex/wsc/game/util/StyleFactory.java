package org.tetawex.wsc.game.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import org.tetawex.wsc.game.core.AssetProviderImpl;

/**
 * Created by Tetawex on 23.05.2017.
 */
public class StyleFactory {
    private static Skin skin;

    public static Skin getSkin(AssetProviderImpl assetProvider) {
        if (skin == null) {
            Skin skin = new Skin();
            skin.addRegions(assetProvider.getAssetManager().get("atlas.atlas", TextureAtlas.class));
        }
        return skin;
    }

    public static Label.LabelStyle generateStandardLabelStyle(AssetProviderImpl assetProvider) {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = assetProvider.getAssetManager().get("fonts/font_main_medium.ttf", BitmapFont.class);
        style.fontColor = new Color(1f, 1f, 1f, 0.87f);
        return style;
    }

    public static ProgressBar.ProgressBarStyle generateLoadingMenuProgressBarStyle(AssetProviderImpl assetProvider) {
        Skin skin = new Skin();
        skin.addRegions(assetProvider.getPreTextureAtlas());
        ProgressBar.ProgressBarStyle style = new ProgressBar.ProgressBarStyle();
        style.knobBefore = new NinePatchDrawable(skin.getPatch("pb_fill"));
        style.background = new NinePatchDrawable(skin.getPatch("pb_bg"));
        return style;
    }

    public static TextButton.TextButtonStyle generateStandardMenuButtonStyle(AssetProviderImpl assetProvider) {
        Skin skin = new Skin();
        skin.addRegions(assetProvider.getAssetManager().get("atlas.atlas", TextureAtlas.class));
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        NinePatchDrawable ninePatch = new NinePatchDrawable(skin.getPatch("button_menu"));
        style.font = assetProvider.getAssetManager().get("fonts/font_main_medium.ttf", BitmapFont.class);
        style.fontColor = new Color(1f, 1f, 1f, 0.87f);
        style.downFontColor = new Color(1, 1, 1, 0.35f);
        style.up = new Image(ninePatch).getDrawable();
        style.checked = new Image(ninePatch).getDrawable();
        ninePatch = new NinePatchDrawable(skin.getPatch("button_menu_pressed"));
        style.down = new Image(ninePatch).getDrawable();

        return style;
    }
}
