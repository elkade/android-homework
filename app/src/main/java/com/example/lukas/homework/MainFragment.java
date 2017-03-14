package com.example.lukas.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;


public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Context context = getContext();
        ShoppingItemsRepository repo = new ShoppingItemsRepository(context);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.shopping_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<ShoppingItem> list = repo.getItems();
        ShoppingAdapter shoppingAdapter = new ShoppingAdapter(list, getActivity());
        recyclerView.setAdapter(shoppingAdapter);

        FloatingActionButton addButton = (FloatingActionButton) view.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditActivity.class));
            }
        });

        return view;
    }
}