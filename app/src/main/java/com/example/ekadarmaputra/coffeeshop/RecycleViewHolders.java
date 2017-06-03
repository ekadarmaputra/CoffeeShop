package com.example.ekadarmaputra.coffeeshop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ekadarmaputra on 5/13/17.
 */

public class RecycleViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView MenuName;
    public ImageView MenuPhoto;

    public RecycleViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        MenuName = (TextView)itemView.findViewById(R.id.menu_name);
        MenuPhoto = (ImageView)itemView.findViewById(R.id.menu_photo);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "Clicked Menu Position " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}
