package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void order(View v){
        display(1);
        displayPrice(2*5);
        Toast.makeText(this,"ordered ..",Toast.LENGTH_SHORT).show();
    }

    private void display(int i){
        TextView quantityOfOrder = findViewById(R.id.Quantity);
        quantityOfOrder.setText(i);
    }

    private void displayPrice(int i){
        TextView priceOf = findViewById(R.id.price);
        priceOf.setText(NumberFormat.getCurrencyInstance().format(i));
    }
}