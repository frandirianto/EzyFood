package com.example.ezyfood.data;

import com.example.ezyfood.R;
import com.example.ezyfood.interfaces.Item;
import com.example.ezyfood.models.Food;

import java.util.ArrayList;

public class Drinks {

        private static ArrayList<Item> listDrink;

        private static void setRecommendedDrinksData(){
            listDrink.add(new Food(R.drawable.pic_avocado_juice, "Fit Fresh Avocado Juice", "Avocado Juice",10000));
            listDrink.add(new Food(R.drawable.pic_orange_juice, "Kroger Orange Juice", "Orange Juice",10000));
            listDrink.add(new Food(R.drawable.pic_aqua, "Aqua Mineral Water", "Mineral Water",5000));
        }

        private static void setTopSellingDrinksData(){
            listDrink.add(new Food(R.drawable.pic_lemon_tea, "Da Vince Lemon Tea", "Lemon Tea",10000));
            listDrink.add(new Food(R.drawable.pic_coffee, "Nescafe Coffee", "Coffee",5000));
            listDrink.add(new Food(R.drawable.pic_cola, "Coca-cola", "Soft drink",5000));
        }
        public static ArrayList<Item> getRecommendedDrinks() {
            listDrink = new ArrayList<>();
            setRecommendedDrinksData();
            return listDrink;
        }

        public static ArrayList<Item> getTopSellingDrinks() {
            listDrink = new ArrayList<>();
            setTopSellingDrinksData();
            return listDrink;
        }
    }

