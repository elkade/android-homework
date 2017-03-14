package com.example.lukas.homework;

import android.content.Context;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
                .inflate(R.layout.layout_shopping_item, null);
        ShoppingViewHolder shoppingViewHolder = new ShoppingViewHolder(view);
        return shoppingViewHolder;
    }

    @Override
    public void onBindViewHolder(ShoppingViewHolder holder, int position) {
        ShoppingItem shoppingItem = list.get(position);
        holder.mTitleView.setText(shoppingItem.getTitle());
        holder.mDescriptionView.setText(shoppingItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return (list != null) ? list.size() : 0;
    }
}