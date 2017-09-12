package org.tetawex.wsc.base.util;

/**
 * Created by tetawex on 09.09.17.
 */
public class Locale {
    private String code;
    private String name;

    public Locale(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Locale toNativeLocale() {
        String[] codes = code.split("_");
        return new java.util.Locale(codes[0], codes[1]);
    }
}
