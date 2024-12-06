package com.example.apphandmade;

import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphandmade.Adapter.Adapterrecyler;
import com.example.apphandmade.helper.DataBaseHelper;
import com.example.apphandmade.model.Mathang;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapterrecyler adapter;
    DataBaseHelper databaseHelper;
    ArrayList<Mathang> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler);


        recyclerView = findViewById(R.id.cardview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseHelper = new DataBaseHelper(this);
        productList = new ArrayList<>();

        storeDataInArrays();
    }

    public ArrayList<Mathang> storeDataInArrays() {
        Cursor cursor = databaseHelper.getdata();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String Ten = cursor.getString(1);
                int Gia = cursor.getInt(6);
                byte[] image = cursor.getBlob(5);
                productList.add(new Mathang(id, Ten, Gia, image));
            }
        }
        cursor.close();
        return productList;
    }
}