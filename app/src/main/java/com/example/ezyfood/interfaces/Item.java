package com.example.ezyfood.interfaces;

import java.io.Serializable;

public class Item implements Serializable {
    private final int picID;
    private final String name;
    private final String description;
    private final int price;
    private final int stock;

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPicID() {
        return picID;
    }

    public int getStock() {
        return stock;
    }


    public Item(int picID ,  String name,  String description, int price, int stock) {
        this.picID = picID;
        this.name = name;
        this.description= description;
        this.price = price;
        this.stock = stock;
    }
}
