package com.example.apphandmade.views.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphandmade.Account_layout;
import com.example.apphandmade.Danhmuc;
import com.example.apphandmade.R;
import com.example.apphandmade.Shopcart_layout;
import com.example.apphandmade.base.BaseActivity;
import com.example.apphandmade.databinding.ActivityHomeLayoutBinding;
import com.example.apphandmade.databinding.ActivityMainBinding;
import com.example.apphandmade.di.DataSingleton;
import com.example.apphandmade.search_layout;
import com.example.apphandmade.views.auth.ui.login.LoginActivity;
import com.example.apphandmade.views.home.adapter.ProductAdapter;
import com.example.apphandmade.views.home.model.Product;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    DrawerLayout drawerLayout;
    NavigationView navigationv;
    RecyclerView revProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Populate products
//        addProduct();
    }

    @Override
    protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews() {
        drawerLayout = findViewById(R.id.drawelayout);
        navigationv = findViewById(R.id.navigationvieww);
        revProduct = findViewById(R.id.revProduct);

        // Set up RecyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        binding.revProduct.setLayoutManager(gridLayoutManager);

        MenuItem menuItemToHide = navigationv.getMenu().findItem(R.id.logout);
        menuItemToHide.setVisible(false);
        View headerView = navigationv.getHeaderView(0);

        if (getIsLoggedIn()) {
            menuItemToHide.setVisible(true);
            DataSingleton.getInstance().setAccountInfo(userDao.getUserInfo(dataShared.getToken()));
            TextView tvName = headerView.findViewById(R.id.tvName);
            tvName.setText(DataSingleton.getInstance().getAccountInfo().getName());
            Log.e("AAA", "Data name: " + DataSingleton.getInstance().getAccountInfo().getName());
        }

        ImageButton imgMenu = findViewById(R.id.imgMenu);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawelayout.open();
            }
        });

        navigationv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemID = item.getItemId();
                if (itemID == R.id.homee) {
                    Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                } else if (itemID == R.id.search) {
                    Toast.makeText(MainActivity.this, "Search clicked", Toast.LENGTH_SHORT).show();
                    Intent myintent = new Intent(MainActivity.this, search_layout.class);
                    startActivity(myintent);
                } else if (itemID == R.id.gioithieu) {
                    Toast.makeText(MainActivity.this, "Information clicked", Toast.LENGTH_SHORT).show();
                } else if (itemID == R.id.danhmuc) {
                    Toast.makeText(MainActivity.this, "Catalouge clicked", Toast.LENGTH_SHORT).show();
                    Intent danhmucint = new Intent(MainActivity.this, Danhmuc.class);
                    startActivity(danhmucint);
                } else if (itemID == R.id.account) {
                    if (getIsLoggedIn())
                        startActivity(Account_layout.class);
                    else
                        startActivity(LoginActivity.class);
                } else if (itemID == R.id.logout) {
                    dataShared.removeDataLoggOut();
                    startActivity(LoginActivity.class);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ImageButton imgCart = findViewById(R.id.imgCart);
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newintent = new Intent(MainActivity.this, Shopcart_layout.class);
                startActivity(newintent);
            }
        });
        addProduct();
    }

    @Override
    protected void initAction() {


    }

    private void addProduct() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.adopt);
        byte[] imageBytes = getBytesFromBitmap(bitmap);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);
        productDao.addProduct(imageBytes, "Sample Product", 49.99, 4.5f, "This is a sample product.", 100);

        List<Product> productList = new ArrayList<>();
        Cursor cursor = productDao.getAllProducts();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                byte[] image = cursor.getBlob(cursor.getColumnIndexOrThrow("image"));
                String productName = cursor.getString(cursor.getColumnIndexOrThrow("product_name"));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
                float rating = cursor.getFloat(cursor.getColumnIndexOrThrow("rating"));
                String productDetail = cursor.getString(cursor.getColumnIndexOrThrow("product_detail"));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));
                productList.add(new Product(id, image, productName, price, rating, productDetail, quantity));
            } while (cursor.moveToNext());
        }
        cursor.close();

        // Set up the RecyclerView with the ProductAdapter
        ProductAdapter productAdapter = new ProductAdapter(this, productList);
        binding.revProduct.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();
    }

    private byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}
