package com.example.lukas.homework;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingViewHolder> {
    private List<ShoppingItem> list;
    private Context mContext;

    public ShoppingAdapter(List<ShoppingItem> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ShoppingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_shopping_item, parent, false);
        ShoppingViewHolder shoppingViewHolder = new ShoppingViewHolder(view);
        return shoppingViewHolder;
    }

    @Override
    public void onBindViewHolder(ShoppingViewHolder holder, int position) {
        ShoppingItem shoppingItem = list.get(position);
        holder.bindItem(shoppingItem);

    }

    @Override
    public int getItemCount() {
        return (list != null) ? list.size() : 0;
    }

    public void setList(ArrayList<ShoppingItem> list) {
        this.list = list;
    }
}