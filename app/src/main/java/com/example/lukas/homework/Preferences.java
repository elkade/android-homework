package com.example.lukas.homework;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;

public class Preferences {
    private final static String FONT_SIZE = "FONT_SIZE";
    private final static String FONT_COLOR = "FONT_COLOR";

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


    public int getFontColor(){
        String val = open().getString(FONT_COLOR, "2");
        if(val.equals("1"))
            return Color.RED;
        if(val.equals("2"))
            return Color.BLACK;
        if(val.equals("3"))
            return Color.GREEN;
        return Color.CYAN;
    }

    public int getFontSize(){
        String val = open().getString(FONT_SIZE, "2");
        if(val.equals("1"))
            return 18;
        if(val.equals("2"))
            return 22;
        if(val.equals("3"))
            return 30;
        return 40;
    }

}