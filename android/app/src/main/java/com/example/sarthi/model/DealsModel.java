package com.example.sarthi.model;

public class DealsModel {
    String name,img_url,category,sellerId;
    int price;

    public DealsModel(String name, String img_url, String category, int price, String sellerId) {
        this.name = name;
        this.img_url = img_url;
        this.category = category;
        this.price = price;
        this.sellerId = sellerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
