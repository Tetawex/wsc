package org.tetawex.wsc.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.I18NBundle;
import org.tetawex.wsc.base.util.Locale;

/**
 * Created by tetawex on 04.09.17.
 */
public abstract class BaseAssetProvider {
    public void setLoaderListener(LoaderListener loaderListener) {
        this.loaderListener = loaderListener;
    }

    public Texture getTexture(String path) {
        return assetManager.get(path);
    }

    public interface LoaderListener {
        void progressChanged(float newProgress);

        void loadFinished();
    }

    private Locale locale;
    private LoaderListener loaderListener;
    private AssetManager assetManager;
    private I18NBundle i18NBundle;
    private boolean finishedLoading = true;

    public BaseAssetProvider(LoaderListener listener) {
        assetManager = new AssetManager();
        loaderListener = listener;
    }

    public BaseAssetProvider() {
        assetManager = new AssetManager();
    }

    public void dispose() {
        assetManager.dispose();
    }

    public abstract void setupLoad();

    public void preLoad(){
        setupLocalisation();
    }

    public void startLoading() {
        setupLocalisation();
        finishedLoading = false;
    }

    public void update() {
        if (!finishedLoading) {
            if (assetManager.update()) {
                if (loaderListener != null)
                    loaderListener.loadFinished();
                finishedLoading = true;
            }
            if (loaderListener != null)
                loaderListener.progressChanged(assetManager.getProgress());
        }
    }

    public LoaderListener getLoaderListener() {
        return loaderListener;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setLocale(Locale locale) {
        if (!locale.getName().equals(this.locale.getName())) {
            this.locale = locale;
            setupLocalisation();
        }
    }

    public void setupLocalisation() {
        if ("default".equals(locale.getName())) {
            i18NBundle = assetManager.get("i18n/bundle", I18NBundle.class);
            locale.setName(i18NBundle.get("lang_default"));
        } else {
            FileHandle baseFileHandle = Gdx.files.internal("i18n/bundle");
            i18NBundle = I18NBundle.createBundle(baseFileHandle, locale.toNativeLocale());
        }
    }

    public String getLocalisedString(String code) {
        return i18NBundle.get(code);
    }
}
