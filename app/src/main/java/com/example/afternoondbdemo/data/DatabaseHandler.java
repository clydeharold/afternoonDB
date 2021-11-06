package com.example.afternoondbdemo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

import com.example.afternoondbdemo.R;
import com.example.afternoondbdemo.model.Product;
import com.example.afternoondbdemo.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PRODUCT = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY,"
                + Util.KEY_NAME + " TEXT,"
                + Util.KEY_PRICE + " DOUBLE,"
                + Util.KEY_QUANTITY + " INTEGER" + ")";

        db.execSQL(CREATE_TABLE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf(R.string.dp_table);
        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});
    }

    //CRUD

    //Add product

    public int AddProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Util.KEY_NAME,product.getName());
        values.put(Util.KEY_PRICE, product.getPrice());
        values.put(Util.KEY_QUANTITY, product.getQuantity());

        db.insert(Util.TABLE_NAME, null, values);
        Log.d("db-add", "Successfully Added");
        db.close();
        return 1;

    }

    public Product getByIdProduct(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Product product = new Product();
        Cursor cursor = db.query(Util.TABLE_NAME,
                new String[] {Util.KEY_ID, Util.KEY_NAME, Util.KEY_PRICE, Util.KEY_QUANTITY},
                Util.KEY_ID + " =? " + new String[]{String.valueOf(id)},
                null, null, null, null, null);

        if(cursor != null) {
            cursor.moveToFirst();


        product.setId(cursor.getInt(0));
        product.setName(cursor.getString(1));
        product.setPrice(cursor.getLong(2));
        product.setQuantity(cursor.getInt(3));

        }
        return product;
    }

    //Get All Products
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //Select All Contacts
        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        if(cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(cursor.getInt(0));
                product.setName(cursor.getString(1));
                product.setPrice(cursor.getLong(2));
                product.setQuantity(cursor.getInt(3));

                //add product object to list

                productList.add(product);
            }while(cursor.moveToNext());
        }

        return productList;

    }
}
