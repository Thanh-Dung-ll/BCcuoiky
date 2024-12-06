package com.example.apphandmade.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.apphandmade.R;
import com.example.apphandmade.model.Mathang;

import java.util.ArrayList;
import java.util.List;

public class AdapterMathang extends BaseAdapter {
    Context context;
   ArrayList<Mathang> list;

    public AdapterMathang(Context context, ArrayList<Mathang> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_main,null);
        ImageView Anhsp = row.findViewById(R.id.Anhsp);
        TextView txtTensp = row.findViewById(R.id.txttensp);
        TextView txtDongia = row.findViewById(R.id.Dongia);
        ImageButton btnlove = row.findViewById(R.id.themvaoyeuthich);
        ImageButton btnthem = row.findViewById(R.id.themvaogiohang);
        Mathang mathang = list.get(i);
        txtTensp.setText(mathang.Tenhang);
        txtDongia.setText(mathang.Dongia);
        Bitmap anhspbm = BitmapFactory.decodeByteArray(mathang.Anh,0,mathang.Anh.length);
        Anhsp.setImageBitmap(anhspbm);
        return row;
    }
}
