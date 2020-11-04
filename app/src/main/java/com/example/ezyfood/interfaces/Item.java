package com.example.ezyfood.interfaces;

public class Item {
    private final int picID;
    private final String name;
    private final String description;
    private final int price;

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

    public Item(int picID ,  String name,  String description, int price) {
        this.picID = picID;
        this.name = name;
        this.description= description;
        this.price = price;
    }
}
