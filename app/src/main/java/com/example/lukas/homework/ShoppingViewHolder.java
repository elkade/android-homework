package com.example.lukas.homework;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class ShoppingViewHolder extends RecyclerView.ViewHolder {
    TextView mTitleView;
    TextView mDescriptionView;

    public ShoppingViewHolder(View itemView) {
        super(itemView);
        this.mTitleView = (TextView) itemView.findViewById(R.id.item_title);
        this.mDescriptionView = (TextView) itemView.findViewById(R.id.item_description);
    }
}