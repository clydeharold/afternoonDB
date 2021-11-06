package com.example.afternoondbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.afternoondbdemo.data.DatabaseHandler;
import com.example.afternoondbdemo.model.Product;

import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    Button cmdAddProduct;
    EditText txtName, txtPrice, txtQuantity;
    DatabaseHandler db = new DatabaseHandler(AddProductActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        refs();

        cmdAddProduct.setOnClickListener(addNewProduct);
    }

    View.OnClickListener addNewProduct = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Product product = new Product();

            product.setName(txtName.getText().toString());
            product.setPrice(Long.parseLong(txtPrice.getText().toString()));
            product.setQuantity(Integer.parseInt(txtQuantity.getText().toString()));

            int res = db.AddProduct(product);
            if(res == 1) {
                Toast.makeText(getApplicationContext(),"Successfully Added", Toast.LENGTH_SHORT).show();

                List<Product> productList =  db.getAllProducts();

                for(Product prod: productList) {
                    Log.d("MainActivity", "On Create: " + prod.getName());
                }
            }

        }
    };

    public void refs() {
        cmdAddProduct = findViewById(R.id.cmdAddProduct);
        txtName = findViewById(R.id.txtProdName);
        txtPrice = findViewById(R.id.txtProdPrice);
        txtQuantity = findViewById(R.id.txtProdQuan);
    }
}