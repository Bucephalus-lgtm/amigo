package com.example.sarthi.model;

public class ProductModel {
    String name,category,img_url,sellerId;
    int price;

    public ProductModel(String name, String category, String img_url, String sellerId, int price) {
        this.name = name;
        this.category = category;
        this.img_url = img_url;
        this.sellerId = sellerId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
