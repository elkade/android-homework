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
import android.widget.EditText;


public class EditFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_edit, container, false);
        Button loginButton = (Button) view.findViewById(R.id.apply_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getContext();
                ShoppingItemsRepository repo = new ShoppingItemsRepository(context);

                EditText editTitle = (EditText) view.findViewById(R.id.edit_title);
                EditText editDescription = (EditText) view.findViewById(R.id.edit_description);

                ShoppingItem shoppingItem = new ShoppingItem(editTitle.getText().toString(), editDescription.getText().toString());
                repo.insertItem(shoppingItem);

                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        return view;
    }
}