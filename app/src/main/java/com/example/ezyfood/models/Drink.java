package com.example.ezyfood.models;

import com.example.ezyfood.interfaces.Item;

public class Drink extends Item {

    public Drink(int picID, String name, String description, int price, int stock) {
        super(picID, name, description, price, stock);
    }
}
