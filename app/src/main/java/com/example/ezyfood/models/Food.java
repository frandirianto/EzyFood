package com.example.ezyfood.models;

import com.example.ezyfood.interfaces.Item;

public class Food extends Item {

    public Food(int picID, String name, String description, int price) {
        super(picID, name, description, price);
    }
}
