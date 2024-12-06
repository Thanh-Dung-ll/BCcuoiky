package com.example.apphandmade.model;

public class Mathang {
    public int Mahang;
    public String Tenhang;
    public String Mota;
    public String Ngaydang;
    public int Madanhmuc;
    public byte[] Anh;
    public int Dongia;

    public Mathang(int mahang, String tenhang, int dongia, byte[] hinhanh) {
        this.Mahang = mahang;
        this.Tenhang = tenhang;
        this.Dongia = dongia;
        this.Anh = hinhanh;

    }

    public Mathang(int mahang, String tenhang, String mota, String ngaydang, int madanhmuc, byte[] anh, int dongia) {
        Mahang = mahang;
        Tenhang = tenhang;
        Mota = mota;
        Ngaydang = ngaydang;
        Madanhmuc = madanhmuc;
        Anh = anh;
        Dongia = dongia;
    }

    public int getMahang() {
        return Mahang;
    }

    public void setMahang(int mahang) {
        Mahang = mahang;
    }

    public String getTenhang() {
        return Tenhang;
    }

    public void setTenhang(String tenhang) {
        Tenhang = tenhang;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getNgaydang() {
        return Ngaydang;
    }

    public void setNgaydang(String ngaydang) {
        Ngaydang = ngaydang;
    }

    public int getMadanhmuc() {
        return Madanhmuc;
    }

    public void setMadanhmuc(int madanhmuc) {
        Madanhmuc = madanhmuc;
    }

    public byte[] getAnh() {
        return Anh;
    }

    public void setAnh(byte[] anh) {
        Anh = anh;
    }

    public int getDongia() {
        return Dongia;
    }

    public void setDongia(int dongia) {
        Dongia = dongia;
    }
}
