package com.example.afternoondbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.afternoondbdemo.data.DatabaseHandler;
import com.example.afternoondbdemo.model.Product;

public class MainActivity extends AppCompatActivity {

    Button cmdAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmdAdd = findViewById(R.id.cmdAdd);

        cmdAdd.setOnClickListener(startAddProductActivity);

      
    }

    View.OnClickListener startAddProductActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
            startActivity(intent);
        }
    };
}