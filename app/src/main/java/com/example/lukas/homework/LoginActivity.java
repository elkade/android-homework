package com.example.lukas.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTheme().applyStyle(new Preferences(this).getFontStyle().getResId(), true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}