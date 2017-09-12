package org.tetawex.wsc.base.util;

/**
 * Created by tetawex on 04.09.17.
 */
public class ImmutableBundle extends Bundle {
    protected static ImmutableBundle create() {
        return new ImmutableBundle();
    }

    private ImmutableBundle() {
        super();
    }

    public void putItem(String key, Object item) {
        throw new UnsupportedOperationException("u cant modify the bundle, dummy");
    }
}
