package com.example.sarthi.model;

public class SellerItemsModel {
    String name,type,price,img_url,product_id;

    public SellerItemsModel(String name, String type, String price, String img_url, String product_id) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.img_url = img_url;
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}
