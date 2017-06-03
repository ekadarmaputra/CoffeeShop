package com.example.ekadarmaputra.coffeeshop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ekadarmaputra on 5/13/17.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolders> {
    private List<ItemObject> itemList;
    private Context context;

    public RecycleViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecycleViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recyclerview, null);
        RecycleViewHolders rcv = new RecycleViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecycleViewHolders holder, int position) {
        holder.MenuName.setText(itemList.get(position).getName());
        holder.MenuPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
