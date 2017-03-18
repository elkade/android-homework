package com.example.lukas.homework;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Spinner;

public class ShoppingPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTheme().applyStyle(new Preferences(this).getFontStyle().getResId(), true);
        super.onCreate(savedInstanceState);
        Preferences prefs = new Preferences(this);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new ShoppingPreferencesFragment()).commit();
    }

}