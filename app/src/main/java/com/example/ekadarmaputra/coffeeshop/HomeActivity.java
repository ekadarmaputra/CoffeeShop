package com.example.ekadarmaputra.coffeeshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by ekadarmaputra on 5/7/17.
 */

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void cardOrderCoffee(View view){
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
//        intent.putExtra("message", "Home Activity");
        startActivity(intent);
    }

    public void cardTopMenu(View view){
        Intent intent = new Intent(HomeActivity.this, TopMenuActivity.class);
//        intent.putExtra("message", "Home Activity");
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuOrder:
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
//        intent.putExtra("message", "Home Activity");
                startActivity(intent);
                return true;
            case R.id.menuTopMenu:
                Intent intentTopMenu = new Intent(HomeActivity.this, TopMenuActivity.class);
//        intent.putExtra("message", "Home Activity");
                startActivity(intentTopMenu);
                return true;
            case R.id.menuAbout:
                Intent intentAbout = new Intent(HomeActivity.this, AboutActivity.class);
//        intent.putExtra("message", "Home Activity");
                startActivity(intentAbout);
                return true;
            case R.id.menuQuit:
                onQuit();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void onQuit() {
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(this);
        alertbuilder.setMessage("Did you want to quit?");
        alertbuilder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });

        alertbuilder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = alertbuilder.create();
        alert.show();
    }
}
