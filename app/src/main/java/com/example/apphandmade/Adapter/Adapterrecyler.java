package com.example.apphandmade.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphandmade.R;
import com.example.apphandmade.model.Mathang;

import java.util.ArrayList;
import java.util.List;

public class Adapterrecyler extends RecyclerView.Adapter<adapterMH>

{
    private ArrayList<Mathang> listmathang;
    private Context context;
    private Activity activity;
    byte[] anh;

    public Adapterrecyler(ArrayList<Mathang> listmathang, Context context) {
        this.listmathang = listmathang;
        this.context = context;
    }

    @NonNull
    @Override
    public adapterMH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler,parent,false);
        return new adapterMH(itemview);
    }

    @SuppressLint("DiscouragedApi")
    @Override
    public void onBindViewHolder(@NonNull adapterMH holder, int position) {
        Mathang mh = listmathang.get(position);
        holder.Tensp.setText(mh.getTenhang());
        holder.Dongia.setText(mh.getDongia());
        byte[] imageBytes = mh.getAnh();
        if (imageBytes != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            holder.Anhsanpham.setImageBitmap(bitmap);
        } else {
            holder.Anhsanpham.setImageResource(R.drawable.anhsp5); // Hình ảnh mặc định nếu không có ảnh
        }
        holder.Themvaoyeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.Themvaogiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listmathang.size();
    }
}
