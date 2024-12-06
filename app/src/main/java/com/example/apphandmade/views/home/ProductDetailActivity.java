package com.example.apphandmade.views.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apphandmade.R;
import com.example.apphandmade.base.BaseActivity;
import com.example.apphandmade.databinding.ActivityProductDetailBinding;

public class ProductDetailActivity extends BaseActivity<ActivityProductDetailBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ActivityProductDetailBinding getViewBinding() {
        return ActivityProductDetailBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initViews() {
        findViewById(R.id.buttonAddToWishlist); // Retrieve data from intent
        String name = getIntent().getStringExtra("productName");
        String description = getIntent().getStringExtra("productDescription");
        double price = getIntent().getDoubleExtra("productPrice", 0.0);
        float rating = getIntent().getFloatExtra("productRating", 0.0f);
        byte[] image = getIntent().getByteArrayExtra("productImage"); // Set data to views
        if (image != null && image.length > 0) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            binding.productImage.setImageBitmap(bitmap);
        }
        binding.productName.setText(name);
        binding.productDescription.setText(description);
        binding.productPrice.setText(price + " D");
        binding.productRating.setRating(rating);
        binding.productRating.setEnabled(false);
    }

    @Override
    protected void initAction() {

    }
}