package com.example.ezyfood.data;

import com.example.ezyfood.R;
import com.example.ezyfood.interfaces.Item;
import com.example.ezyfood.models.Food;

import java.util.ArrayList;

public class Snacks {
    private static ArrayList<Item> listSnack;

    private static void setRecommendedSnacksData(){
        listSnack.add(new Food(R.drawable.pic_pop_corn, "Caramel Pop Corn", "Pop Corn",80000));
        listSnack.add(new Food(R.drawable.pic_nachos, "Nachos", "Nachos + Cheese Sauce",80000));
        listSnack.add(new Food(R.drawable.pic_french_fries, "French Fries", "French Fries + Cheese Sauce",7000));
    }

    private static void setTopSellingSnacksData(){
        listSnack.add(new Food(R.drawable.pic_citato, "Citato Party Pack", "Citato",12000));
        listSnack.add(new Food(R.drawable.pic_lays, "Lays Party Pack", "Lays",12000));
        listSnack.add(new Food(R.drawable.pic_pringles, "Pringles Sour Cream", "Pringles",13000));
    }
    public static ArrayList<Item> getRecommendedSnacks() {
        listSnack = new ArrayList<>();
        setRecommendedSnacksData();
        return listSnack;
    }

    public static ArrayList<Item> getTopSellingSnacks() {
        listSnack = new ArrayList<>();
        setTopSellingSnacksData();
        return listSnack;
    }
}
