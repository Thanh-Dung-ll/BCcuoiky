package com.example.apphandmade.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphandmade.R;

import java.util.ArrayList;

public class adapterMH extends RecyclerView.ViewHolder{
    protected ImageView Anhsanpham;
    protected TextView Tensp;
    protected TextView Dongia;
    protected ImageButton Themvaoyeuthich;
    protected ImageButton  Themvaogiohang;



    public adapterMH(View itemView) {
        super(itemView);

       Anhsanpham = itemView.findViewById(R.id.Anhsp);
       Tensp= itemView.findViewById(R.id.txttensp);
       Dongia = itemView.findViewById(R.id.Dongia);
       Themvaoyeuthich = itemView.findViewById(R.id.themvaoyeuthich);
       Themvaogiohang = itemView.findViewById(R.id.themvaogiohang);

    }



}
