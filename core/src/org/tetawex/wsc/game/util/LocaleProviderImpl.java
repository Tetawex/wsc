package org.tetawex.wsc.game.util;

import org.tetawex.wsc.base.util.Locale;
import org.tetawex.wsc.base.util.LocaleProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tetawex on 09.09.17.
 */
public class LocaleProviderImpl implements LocaleProvider {
    Map<String, Locale> localeMap;

    public LocaleProviderImpl() {
        localeMap = new HashMap<String, Locale>();
        localeMap.put("default", new Locale("default", "< Auto >"));
        localeMap.put("en_US", new Locale("en_US", "English"));
        localeMap.put("ru_RU", new Locale("ru_RU", "Русский"));
    }

    @Override
    public Locale getLocaleByCode(String code) {
        if (localeMap.containsKey(code))
            return localeMap.get(code);
        return localeMap.get("en_US");
    }
}
