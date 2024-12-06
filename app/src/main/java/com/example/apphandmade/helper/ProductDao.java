package com.example.apphandmade.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductDao {
    private DataBaseHelper dbHelper;

    public ProductDao(Context context) {
        dbHelper = new DataBaseHelper(context);
    }

    // Add a new product
    public void addProduct(byte[] image, String productName, double price, float rating, String productDetail, int quantity) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.COLUMN_IMAGE, image);
        values.put(DataBaseHelper.COLUMN_PRODUCT_NAME, productName);
        values.put(DataBaseHelper.COLUMN_PRICE, price);
        values.put(DataBaseHelper.COLUMN_RATING, rating);
        values.put(DataBaseHelper.COLUMN_PRODUCT_DETAIL, productDetail);
        values.put(DataBaseHelper.COLUMN_QUANTITY, quantity);
        db.insert(DataBaseHelper.TABLE_PRODUCTS, null, values);
        db.close();
    }

    // Retrieve all products
    public Cursor getAllProducts() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM products", null);
    }
}
