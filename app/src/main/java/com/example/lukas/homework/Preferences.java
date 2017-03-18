package com.example.lukas.homework;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    private final static String FONT_STYLE = "FONT_STYLE";

    private final Context context;

    public Preferences(Context context) {
        this.context = context;
    }

    protected SharedPreferences open() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    protected SharedPreferences.Editor edit() {
        return open().edit();
    }

    public FontStyle getFontStyle() {
        String val = open().getString(FONT_STYLE, FontStyle.Large.name());
        return FontStyle.valueOf(val);
    }

    public void setFontStyle(FontStyle style) {
        edit().putString(FONT_STYLE, style.name()).commit();
    }
}