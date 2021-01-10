package com.example.ezyfood.models;

import com.example.ezyfood.interfaces.Item;

public class Snack extends Item {

    public Snack(int picID, String name, String description, int price,  int stock) {
        super(picID, name, description, price, stock);
    }
}
