package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public TextView coffeeNos;
    public int price = 9;
    public EditText name;
    public int finalPrice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffeeNos = findViewById(R.id.Quantity);
        Toast.makeText(this,"Ordered ..",Toast.LENGTH_SHORT).show();



    }

    @SuppressLint("SetTextI18n")
    public void order(View v){
        TextView finalMsg = findViewById(R.id.finalMessage);
        String msg = "Your order of "+coffeeNos.getText()+" coffee had been successfully ordered";
        name = findViewById(R.id.getName);
        String Name = name.getText().toString();


        TextView SummaryName = findViewById(R.id.orderSummaryName);
        SummaryName.setText("Name: "+Name);

        TextView SummaryQuantity = findViewById(R.id.orderSummaryQuantity);
        SummaryQuantity.setText("Quantity: "+coffeeNos.getText().toString());

        TextView summaryPrice = findViewById(R.id.orderSummaryFinalPrice);
        summaryPrice.setText("Final Price: "+String.valueOf(finalPrice));


        finalMsg.setText(msg);

        String s1 = msg +"\n"+"oreder Summary\n"+ "Name: "+Name +"\n"+"Quantity: "+coffeeNos.getText().toString()+"\nFinal Price: "+String.valueOf(finalPrice);

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL,"gshubh782@gmail.com");
        email.putExtra(Intent.EXTRA_SUBJECT, "Coffee order");
        email.putExtra(Intent.EXTRA_TEXT,s1);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client "));

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
        finalPrice=val*price;
        display(val);
        displayPrice(finalPrice);
    }

    public void decrease(View v){

        int val = Integer.parseInt(coffeeNos.getText().toString());

        if(val>0) {
            val--;
            finalPrice=val*price;
            display(val);
            displayPrice(finalPrice);
        }else{
            Toast.makeText(MainActivity.this, "Minimum no of order reached..", Toast.LENGTH_SHORT).show();
        }
    }

    public void whipped(View v){
        CheckBox checkBox = findViewById(R.id.whip);
        int no = Integer.parseInt(coffeeNos.getText().toString());
        if(checkBox.isChecked()){
            finalPrice=finalPrice+no*5;
            displayPrice(finalPrice);
        }else{
            finalPrice=finalPrice-no*5;
            displayPrice(finalPrice);
        }
    }

    public void choco(View v){
        CheckBox checkBox = findViewById(R.id.choco);
        int no = Integer.parseInt(coffeeNos.getText().toString());
        if(checkBox.isChecked()){
            finalPrice=finalPrice+no*7;
            displayPrice(finalPrice);
        }else{
            finalPrice=finalPrice-no*7;
            displayPrice(finalPrice);
        }
    }
}