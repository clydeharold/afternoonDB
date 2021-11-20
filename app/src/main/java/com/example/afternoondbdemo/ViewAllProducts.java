package com.example.afternoondbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.afternoondbdemo.data.DatabaseHandler;
import com.example.afternoondbdemo.model.Product;

import java.util.ArrayList;
import java.util.List;


public class ViewAllProducts extends AppCompatActivity {

    ListView viewProducts;
    private ArrayList<String> productArrayList;
    private ArrayAdapter<String> arrayAdapter;

    DatabaseHandler db = new DatabaseHandler(ViewAllProducts.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_products);

        productArrayList = new ArrayList<>();
        viewProducts = findViewById(R.id.viewProducts);

        List<Product> productList = db.getAllProducts();

        for(Product product: productList) {
            //Log.d("ViewActivity", "On Create: " + product.getName() + ", " + product.getId());
            productArrayList.add(product.getName());
        }

        //create array adapter
        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                productArrayList
        );

        //add to our listview
        viewProducts.setAdapter(arrayAdapter);

        viewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), " " +productList.get(position).getPrice(), Toast.LENGTH_SHORT).show();
                //in
            }
        });

    }
}