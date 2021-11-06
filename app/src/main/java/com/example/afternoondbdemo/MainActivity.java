package com.example.afternoondbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.afternoondbdemo.data.DatabaseHandler;
import com.example.afternoondbdemo.model.Product;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Product product = new Product();

        product.setName("Monitor");
        product.setPrice((long) 2500.50);
        product.setQuantity(5);

        db.AddProduct(product);
    }
}