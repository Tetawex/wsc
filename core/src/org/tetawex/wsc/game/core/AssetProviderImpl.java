package org.tetawex.wsc.game.core;

import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import org.tetawex.wsc.base.BaseAssetProvider;
import org.tetawex.wsc.game.util.FontCharacters;

/**
 * Created by tetawex on 09.09.17.
 */
public class AssetProviderImpl extends BaseAssetProvider {
    private TextureAtlas mainTextureAtlas;
    private TextureAtlas preTextureAtlas;

    public TextureAtlas getMainTextureAtlas() {
        return mainTextureAtlas;
    }

    public TextureAtlas getPreTextureAtlas() {
        return preTextureAtlas;
    }

    @Override
    public void finishLoading() {
        mainTextureAtlas = getAssetManager().get("atlas.atlas", TextureAtlas.class);
    }

    public AssetProviderImpl() {
        super();
    }

    public TextureRegion getTextureRegionFromMainAtlas(String name) {
        return mainTextureAtlas.findRegion(name);
    }

    public TextureRegion getTextureRegionFromPreLoadedAtlas(String name) {
        return preTextureAtlas.findRegion(name);
    }

    @Override
    public void setupLoad() {
        getAssetManager().load("atlas.atlas", TextureAtlas.class);
        getAssetManager().load("backgrounds/background.png", Texture.class);
        getAssetManager().load("backgrounds/test.png", Texture.class);
        getAssetManager().load("backgrounds/te22st.png", Texture.class);
        getAssetManager().load("backgrounds/test2.png", Texture.class);
    }

    @Override
    public void preLoad() {
        super.preLoad();
        getPreAssetManager().load("pl_atlas.atlas", TextureAtlas.class);
        getPreAssetManager().load("backgrounds/background_loading.png", Texture.class);
        loadFonts();
        getPreAssetManager().finishLoading();
        preTextureAtlas = getPreAssetManager().get("pl_atlas.atlas", TextureAtlas.class);
    }

    private void loadFonts() {
        FileHandleResolver resolver = new InternalFileHandleResolver();
        getPreAssetManager().setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        getPreAssetManager().setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        // load to fonts via the generator (implicitly done by the FreetypeFontLoader).
        // Note: you MUST specify a FreetypeFontGenerator defining the ttf font file name and the size
        // of the font to be generated. The names of the fonts are arbitrary and are not pointing
        // to a file on disk!


        FreetypeFontLoader.FreeTypeFontLoaderParameter paramsS = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        paramsS.fontParameters.characters = FontCharacters.en + FontCharacters.ru;
        paramsS.fontFileName = "fonts/font_main.ttf";
        paramsS.fontParameters.size = 48;
        getPreAssetManager().load("fonts/font_main_small.ttf", BitmapFont.class, paramsS);

        FreetypeFontLoader.FreeTypeFontLoaderParameter paramsM = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        paramsM.fontParameters.characters = FontCharacters.en + FontCharacters.ru;
        paramsM.fontFileName = "fonts/font_main.ttf";
        paramsM.fontParameters.size = 75;
        getPreAssetManager().load("fonts/font_main_medium.ttf", BitmapFont.class, paramsM);

        FreetypeFontLoader.FreeTypeFontLoaderParameter paramsL = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        paramsL.fontParameters.characters = FontCharacters.en + FontCharacters.ru;
        paramsL.fontFileName = "fonts/font_main.ttf";
        paramsL.fontParameters.size = 96;
        getPreAssetManager().load("fonts/font_main_large.ttf", BitmapFont.class, paramsL);
    }
}
