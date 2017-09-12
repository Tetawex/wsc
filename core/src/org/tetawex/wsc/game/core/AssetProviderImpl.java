package org.tetawex.wsc.game.core;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.utils.I18NBundle;
import org.tetawex.wsc.base.BaseAssetProvider;
import org.tetawex.wsc.game.util.FontCharacters;

/**
 * Created by tetawex on 09.09.17.
 */
public class AssetProviderImpl extends BaseAssetProvider {
    private TextureAtlas mainTextureAtlas;
    public AssetProviderImpl() {
        super();
    }

    public TextureRegion getTextureRegionFromMainAtlas(String name) {
        return mainTextureAtlas.findRegion(name);
    }

    @Override
    public void setupLoad() {
        getAssetManager().load("atlas.atlas", TextureAtlas.class);
        getAssetManager().load("backgrounds/background.png", Texture.class);
        getAssetManager().load("i18n/bundle", I18NBundle.class);
        loadFonts();
    }

    private void loadFonts() {
        FileHandleResolver resolver = new InternalFileHandleResolver();
        getAssetManager().setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        getAssetManager().setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        // load to fonts via the generator (implicitly done by the FreetypeFontLoader).
        // Note: you MUST specify a FreetypeFontGenerator defining the ttf font file name and the size
        // of the font to be generated. The names of the fonts are arbitrary and are not pointing
        // to a file on disk!


        FreetypeFontLoader.FreeTypeFontLoaderParameter paramsS = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        paramsS.fontParameters.characters = FontCharacters.en + FontCharacters.ru;
        paramsS.fontFileName = "fonts/font_main.ttf";
        paramsS.fontParameters.size = 48;
        getAssetManager().load("fonts/font_main_small.ttf", BitmapFont.class, paramsS);

        FreetypeFontLoader.FreeTypeFontLoaderParameter paramsM = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        paramsM.fontParameters.characters = FontCharacters.en + FontCharacters.ru;
        paramsM.fontFileName = "fonts/font_main.ttf";
        paramsM.fontParameters.size = 75;
        getAssetManager().load("fonts/font_main_medium.ttf", BitmapFont.class, paramsM);

        FreetypeFontLoader.FreeTypeFontLoaderParameter paramsL = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        paramsL.fontParameters.characters = FontCharacters.en + FontCharacters.ru;
        paramsL.fontFileName = "fonts/font_main.ttf";
        paramsL.fontParameters.size = 96;
        getAssetManager().load("fonts/font_main_large.ttf", BitmapFont.class, paramsL);
    }
}
