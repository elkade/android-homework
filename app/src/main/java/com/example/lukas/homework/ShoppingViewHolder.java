package com.example.lukas.homework;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class ShoppingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView mTitleView;
    TextView mDescriptionView;
    ImageButton deleteButton;
    ImageButton editButton;
    ShoppingItem item;

    public ShoppingViewHolder(View itemView) {
        super(itemView);
        this.mTitleView = (TextView) itemView.findViewById(R.id.item_title);
        this.mDescriptionView = (TextView) itemView.findViewById(R.id.item_description);
        deleteButton = (ImageButton) itemView.findViewById(R.id.delete_button);
        itemView.setOnClickListener(this);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("deleteButton", "CLICK!");
            }
        });

        editButton = (ImageButton) itemView.findViewById(R.id.edit_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("editButton", "CLICK!");
            }
        });
    }
    public void bindItem(ShoppingItem item) {
        this.item = item;
        //Picasso.with(mItemImage.getContext()).load(photo.getUrl()).into(mItemImage);
        mTitleView.setText(item.getTitle());
        mDescriptionView.setText(item.getDescription());
    }
    @Override
    public void onClick(View itemView) {
        Log.d("RecyclerView", "CLICK!");
        Context context = itemView.getContext();
        Intent showEditIntent = new Intent(context, EditActivity.class);
        showEditIntent.putExtra("item", item);
        context.startActivity(showEditIntent);
    }
}