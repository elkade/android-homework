package com.example.lukas.homework;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class ShoppingPreferencesFragment extends PreferenceFragment {
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

    }
}
