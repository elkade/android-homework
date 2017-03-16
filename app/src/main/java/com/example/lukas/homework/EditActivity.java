package com.example.lukas.homework;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    ShoppingItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        item = (ShoppingItem)getIntent().getSerializableExtra("item");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    public ShoppingItem getItem(){
        return item;
    }
}
