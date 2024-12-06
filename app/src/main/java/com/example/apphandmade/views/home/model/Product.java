package com.example.apphandmade.views.home.model;

public class Product {
    private int id;
    private byte[] image;
    private String productName;
    private double price;
    private float rating;
    private String productDetail;
    private int quantity;

    public Product(int id, byte[] image, String productName, double price, float rating, String productDetail, int quantity) {
        this.id = id;
        this.image = image;
        this.productName = productName;
        this.price = price;
        this.rating = rating;
        this.productDetail = productDetail;
        this.quantity = quantity;
    }

    // Getter methods
    public int getId() { return id; }
    public byte[] getImage() { return image; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public float getRating() { return rating; }
    public String getProductDetail() { return productDetail; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "Product{id=" + id + ", productName='" + productName + "', price=" + price +
                ", rating=" + rating + ", productDetail='" + productDetail + "', quantity=" + quantity + "}";
    }
}
