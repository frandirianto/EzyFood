package com.example.ezyfood.data;

import com.example.ezyfood.R;
import com.example.ezyfood.interfaces.Item;
import com.example.ezyfood.models.Food;

import java.util.ArrayList;

public class Foods {
    private static ArrayList<Item> listFood = new ArrayList<Item>();

    public static void createFoodMenu(){
        setData();
    }

    private static void setData(){
        listFood.add(new Food(R.drawable.pizza, "Pizza", "Pizza with cheese",120000));
        listFood.add(new Food(R.drawable.pizza, "Pizza", "Pizza with cheese",120000));
        listFood.add(new Food(R.drawable.pizza, "Pizza", "Pizza with cheese",120000));
    }

    public static ArrayList<Item> getListFood() {
        return listFood;
    }
}
