package com.example.lukas.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class EditFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        Button loginButton = (Button) view.findViewById(R.id.apply_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getContext();
                ShoppingItemsRepository repo = new ShoppingItemsRepository(context);
                repo.insertItem(new ShoppingItem("ABC", "DEF"));
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        return view;
    }
}