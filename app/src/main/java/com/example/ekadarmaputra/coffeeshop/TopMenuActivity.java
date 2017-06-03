package com.example.ekadarmaputra.coffeeshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class TopMenuActivity extends AppCompatActivity {

    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);
        setTitle("Top Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(TopMenuActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecycleViewAdapter rcAdapter = new RecycleViewAdapter(TopMenuActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }

        else{
            return super.onOptionsItemSelected(item);
        }
    }

    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Cappucino", R.drawable.cappucinotwo));
        allItems.add(new ItemObject("Moccacino", R.drawable.moccacino));
        allItems.add(new ItemObject("Latte", R.drawable.latte));
        allItems.add(new ItemObject("Green Tea Coffee", R.drawable.green_tea_latte));

        return allItems;
    }
}
