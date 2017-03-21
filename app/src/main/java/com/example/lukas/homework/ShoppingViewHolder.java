package com.example.lukas.homework;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.util.TypedValue.COMPLEX_UNIT_SP;


public class ShoppingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView mTitleView;
    TextView mDescriptionView;
    TextView mPriceView;
    ShoppingItem item;
    ImageView image;
    private View itemView;

    public ShoppingViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.mTitleView = (TextView) itemView.findViewById(R.id.item_title);
        this.mDescriptionView = (TextView) itemView.findViewById(R.id.item_description);
        this.mPriceView = (TextView) itemView.findViewById(R.id.item_price);
        image = (ImageView)itemView.findViewById(R.id.item_image);
        this.itemView = itemView;

        itemView.setOnClickListener(this);
    }
    public void bindItem(ShoppingItem item) {
        this.item = item;
        String url = item.getPhotoUrl();
        if(!url.equals(""))
            Picasso.with(image.getContext()).load(url).into(image);
        int size = new Preferences(itemView.getContext()).getFontSize();
        int color = new Preferences(itemView.getContext()).getFontColor();
        updateTextView(mTitleView,size,color,item.getTitle());
        updateTextView(mDescriptionView, size, color, item.getDescription());
        updateTextView(mPriceView, size, color, Double.toString(item.getPrice()));
    }

    private void updateTextView(TextView view, int size, int color, String text){
        view.setTextSize(COMPLEX_UNIT_SP, size);
        view.setTextColor(color);
        view.setText(text);
    }

    @Override
    public void onClick(View itemView) {
        Log.d("RecyclerView", "CLICK!");
        Context context = itemView.getContext();
        Intent showEditIntent = new Intent(context, EditActivity.class);
        showEditIntent.putExtra("item", item);
        ((Activity)context).startActivityForResult(showEditIntent, 0);
    }
}