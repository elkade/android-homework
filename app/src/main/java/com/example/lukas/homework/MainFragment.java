package com.example.lukas.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ShoppingAdapter shoppingAdapter;
    private ShoppingItemsRepository repo;
    private List<ShoppingItem> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Context context = getContext();

        repo = new ShoppingItemsRepository(context);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.shopping_list);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();
        ShoppingItem item = repo.getNext(-1);
        if(item!=null)
            list.add(item);
        shoppingAdapter = new ShoppingAdapter(list, getActivity());
        recyclerView.setAdapter(shoppingAdapter);
        setRecyclerViewScrollListener();
        setRecyclerViewItemTouchListener();
        FloatingActionButton addButton = (FloatingActionButton) view.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditActivity.class));
            }
        });

        return view;
    }

    private int getLastVisibleItemPosition() {
        return linearLayoutManager.findLastVisibleItemPosition();
    }

    private void setRecyclerViewScrollListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int totalItemCount = recyclerView.getLayoutManager().getItemCount();
                if (totalItemCount != getLastVisibleItemPosition() + 1)
                    return;
                loadNextItem();
            }
        });
    }

    private void loadNextItem() {
        ShoppingItem item ;
        if(list.isEmpty())
            item = repo.getNext(-1);
        else {

            ShoppingItem last = list.get(list.size() - 1);

            item = repo.getNext(last.getId());
        }
        if (item == null)
            return;
        list.add(item);

        shoppingAdapter.notifyItemInserted(list.size());
    }

    private void setRecyclerViewItemTouchListener() {

        //1
        ItemTouchHelper.SimpleCallback itemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
                //2
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                //3
                int position = viewHolder.getAdapterPosition();
                ShoppingItem item = list.get(position);
                repo.deleteItem(item.getId());
                list.remove(position);
                recyclerView.getAdapter().notifyItemRemoved(position);
                if(list.isEmpty())
                    loadNextItem();
            }
        };

        //4
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}