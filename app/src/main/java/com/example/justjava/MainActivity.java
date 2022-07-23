package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public TextView coffeeNos;
    public int price = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffeeNos = findViewById(R.id.Quantity);
        Toast.makeText(this,"Ordered ..",Toast.LENGTH_SHORT).show();
    }

    public void order(View v){
        TextView finalMsg = findViewById(R.id.finalMessage);
        String msg = "Your order of "+coffeeNos.getText()+" has been successfully ordered";
        finalMsg.setText(msg);
    }

    private void display(int i){
        coffeeNos.setText(String.valueOf(i));
    }

    private void displayPrice(int i){
        TextView priceOf = findViewById(R.id.price);
        priceOf.setText(NumberFormat.getCurrencyInstance().format(i));


    }

    public void increase(View v){
        int val = Integer.parseInt(coffeeNos.getText().toString());
        val++;
        display(val);
        displayPrice(val*price);
    }

    public void decrease(View v){

        int val = Integer.parseInt(coffeeNos.getText().toString());

        if(val>0) {
            val--;
            display(val);
            displayPrice(val * price);
        }else{
            Toast.makeText(MainActivity.this, "Minimum no of order reached..", Toast.LENGTH_SHORT).show();
        }
    }
}