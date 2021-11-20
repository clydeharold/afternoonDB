package com.example.afternoondbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.afternoondbdemo.data.DatabaseHandler;
import com.example.afternoondbdemo.model.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button cmdAdd, cmdViewAll;
    DatabaseHandler db = new DatabaseHandler(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmdAdd = findViewById(R.id.cmdAdd);
        cmdViewAll = findViewById(R.id.cmdViewAll);

        cmdAdd.setOnClickListener(startAddProductActivity);
        cmdViewAll.setOnClickListener(startViewAllActivity);

        Product product = new Product();

        product.setId(1);
        product.setName("Asus Monitor");
        product.setPrice(14000);
        product.setQuantity(5);

        if(db.updateProduct(product) == 0) {
            Toast.makeText(getApplicationContext(), "Product not updated. Please contact admin", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Product Successfully updated",Toast.LENGTH_SHORT).show();
        }

    }

    View.OnClickListener startViewAllActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ViewAllProducts.class)    ;
            startActivity(intent);
        }
    };

    View.OnClickListener startAddProductActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
            startActivity(intent);
        }
    };

    public void testButtonClick(View view) {
        Toast.makeText(getApplicationContext(),"This is a test", Toast.LENGTH_SHORT).show();
    }
}