package com.example.apphandmade.views.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphandmade.R;
import com.example.apphandmade.views.home.ProductDetailActivity;
import com.example.apphandmade.views.home.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        Bitmap bitmap = BitmapFactory.decodeByteArray(product.getImage(), 0, product.getImage().length);
        holder.imageView.setImageBitmap(bitmap);
        holder.productName.setText(product.getProductName());
        holder.price.setText(String.valueOf(product.getPrice()));
//        holder.ratingBar.setRating(product.getRating());
//        holder.quantity.setText(String.valueOf(product.getQuantity()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("productImage", product.getImage());
                intent.putExtra("productName", product.getProductName());
                intent.putExtra("productDescription", product.getProductDetail());
                intent.putExtra("productPrice", product.getPrice());
                intent.putExtra("productRating", product.getRating());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView productName, price, quantity;
        RatingBar ratingBar;
        ImageButton addToFavorites, addToCart;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Anhsp);
            productName = itemView.findViewById(R.id.txttensp);
            price = itemView.findViewById(R.id.Dongia);
//            ratingBar = itemView.findViewById(R.id.ratingBar);
            addToFavorites = itemView.findViewById(R.id.themvaoyeuthich);
            addToCart = itemView.findViewById(R.id.themvaogiohang);
        }
    }
}



