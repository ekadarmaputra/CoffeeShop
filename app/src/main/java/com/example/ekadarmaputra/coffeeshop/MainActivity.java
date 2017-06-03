package com.example.ekadarmaputra.coffeeshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mEditName;
    private Spinner MenuSpinner;
    private Button mButtonDecrease, mButtonIncrease, mButtonNext, mButtonReset;
    private TextView mQuantity, mShowPrice;
    private RadioGroup mFlavor;
    private int quantity = 0;
    private int price = 0;

    private List<String> categories = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Order Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
        initEvent();
    }

    public void initView(){
        mEditName = (EditText) findViewById(R.id.mEditName);
        MenuSpinner = (Spinner) findViewById(R.id.MenuSpinner);
        mButtonDecrease = (Button) findViewById(R.id.ButtonDecrease);
        mButtonIncrease = (Button) findViewById(R.id.ButtonIncrease);
        mButtonNext = (Button) findViewById(R.id.mButtonNext);
        mButtonReset = (Button) findViewById(R.id.mButtonReset);
        mQuantity = (TextView) findViewById(R.id.mQuantity);
        mShowPrice = (TextView) findViewById(R.id.mShowPrice);
        mFlavor = (RadioGroup) findViewById(R.id.mFlavor);
    }

    public void initEvent(){


        mButtonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                mQuantity.setText(String.valueOf(quantity));
                price = quantity * 5;
                mShowPrice.setText("Price is $" + price);
            }
        });

        mButtonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(quantity >= 1){
                    quantity--;
                }

                mQuantity.setText(String.valueOf(quantity));
                price = quantity * 5;
                mShowPrice.setText("Price is $" + price);


            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = 0;
                price = 0;
                mQuantity.setText(String.valueOf(quantity));
                mShowPrice.setText("Price is $" + price);
            }
        });


        //Spinner

        //categories.add(" ");
        categories.add("Coffee");
        categories.add("Tea");
        categories.add("Milk");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        MenuSpinner.setAdapter(dataAdapter);
        MenuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, parent.getSelectedItem() + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mFlavor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.mFlavorChocolate:
                        Toast.makeText(MainActivity.this, "Chocolate flavor", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.mFlavorVanilla:
                        Toast.makeText(MainActivity.this, "Moccha flavor", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
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

    protected void sendEmail(){
        String[] TO = {"eka.younggeneration@gmail.com"};
        Intent emailIntent = new Intent (Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto: "));
        emailIntent.setType("text/Plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Order");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Nama saya " + mEditName.getText() + " saya memesan " + MenuSpinner.getSelectedItem() +
                " sebanyak " + mQuantity.getText() + " seharga $" + price
            );

        try{
            startActivity(Intent.createChooser(emailIntent, "send mail ...."));
            finish();
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(this, "unable to send the email", Toast.LENGTH_LONG).show();
        }
    }


}
