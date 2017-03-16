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
    EditText editTitle;
    EditText editDescription;
    ShoppingItem item;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_edit, container, false);
        Button loginButton = (Button) view.findViewById(R.id.apply_button);

        item = ((EditActivity) getActivity()).getItem();

        editTitle = (EditText) view.findViewById(R.id.edit_title);

        editDescription = (EditText) view.findViewById(R.id.edit_description);
        if(item!=null){
            editTitle.setText(item.getTitle());
            editDescription.setText(item.getDescription());
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getContext();
                ShoppingItemsRepository repo = new ShoppingItemsRepository(context);
                if(item == null) {
                    item = new ShoppingItem(editTitle.getText().toString(), editDescription.getText().toString());
                    repo.insertItem(item);
                }
                else{
                    item.setTitle(editTitle.getText().toString());
                    item.setDescription(editDescription.getText().toString());
                    repo.updateItem(item);
                }
                getActivity().finish();
                //startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        return view;
    }
}