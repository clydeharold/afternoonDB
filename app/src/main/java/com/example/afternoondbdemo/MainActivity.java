package com.example.afternoondbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.afternoondbdemo.data.DatabaseHandler;
import com.example.afternoondbdemo.model.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Product prod = db.getProduct(1);
        Log.d("Search-id", "PRODUCT: " + prod.getName());

        List<Product> productList =  db.getAllProducts();

        for(Product product: productList) {
            Log.d("MainActivity", "On Create: " + product.getId() + "-" + product.getName());
        }

    }
}