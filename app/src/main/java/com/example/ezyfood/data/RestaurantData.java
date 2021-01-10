package com.example.ezyfood.data;

import com.example.ezyfood.R;
import com.example.ezyfood.interfaces.Item;
import com.example.ezyfood.models.Drink;
import com.example.ezyfood.models.Food;
import com.example.ezyfood.models.Restaurant;
import com.example.ezyfood.models.Snack;

import java.util.ArrayList;
import java.util.Random;

public class RestaurantData {

    public static ArrayList<Restaurant> restaurants;
    public static Random random = new Random();

    public static Restaurant setItem(){
        Restaurant res = new Restaurant();

        ArrayList<Item> listDrink = new ArrayList<>();
        listDrink.add(new Drink(R.drawable.pic_avocado_juice, "Fit Fresh Avocado Juice", "Avocado Juice",10000, random.nextInt(30)+1));
        listDrink.add(new Drink(R.drawable.pic_orange_juice, "Kroger Orange Juice", "Orange Juice",10000,random.nextInt(30)+1));
        listDrink.add(new Drink(R.drawable.pic_aqua, "Aqua Mineral Water", "Mineral Water",5000,random.nextInt(30)+1));
        listDrink.add(new Drink(R.drawable.pic_lemon_tea, "Da Vince Lemon Tea", "Lemon Tea",10000,random.nextInt(30)+1));
        listDrink.add(new Drink(R.drawable.pic_coffee, "Nescafe Coffee", "Coffee",5000,random.nextInt(30)+1));
        listDrink.add(new Drink(R.drawable.pic_cola, "Coca-cola", "Soft drink",5000,random.nextInt(30)+1));

        ArrayList<Item> listFood = new ArrayList<>();
        listFood.add(new Food(R.drawable.pic_ayam_bakar, "Ayam Bakar Spesial", "Ayam Bakar 1 ekor",15000,random.nextInt(30)+1));
        listFood.add(new Food(R.drawable.pic_gurami_goreng, "Gurami Goreng Asin", "Gurami Goreng 1 ekor",20000,random.nextInt(30)+1));
        listFood.add(new Food(R.drawable.pic_gurami_bakar, "Gurami Bakar", "Gurami Bakar 1 ekor",20000,random.nextInt(30)+1));
        listFood.add(new Food(R.drawable.pic_nasi_goreng, "Nasi Goreng Spesial", "Nasi Drinks + Telur + Daging Sapi",12000,random.nextInt(30)+1));
        listFood.add(new Food(R.drawable.pic_sate_ayam, "Sate Ayam", "Sate Ayam 15 tusuk",15000,random.nextInt(30)+1));
        listFood.add(new Food(R.drawable.pic_mie_ayam, "Mie Ayam", "Mie Ayam + Pangsit Goreng",12000,random.nextInt(30)+1));

        ArrayList<Item> listSnack = new ArrayList<>();
        listSnack.add(new Snack(R.drawable.pic_pop_corn, "Caramel Pop Corn", "Pop Corn",80000,random.nextInt(30)+1));
        listSnack.add(new Snack(R.drawable.pic_nachos, "Nachos", "Nachos + Cheese Sauce",80000,random.nextInt(30)+1));
        listSnack.add(new Snack(R.drawable.pic_french_fries, "French Fries", "French Fries + Cheese Sauce",7000,random.nextInt(30)+1));
        listSnack.add(new Snack(R.drawable.pic_citato, "Citato Party Pack", "Citato",12000,random.nextInt(30)+1));
        listSnack.add(new Snack(R.drawable.pic_lays, "Lays Party Pack", "Lays",12000,random.nextInt(30)+1));
        listSnack.add(new Snack(R.drawable.pic_pringles, "Pringles Sour Cream", "Pringles",13000,random.nextInt(30)+1));

        res.setDrinks(listDrink);
        res.setFoods((listFood));
        res.setSnacks(listSnack);
        return res;
    }

    public static void setRestaurant(){
        restaurants = new ArrayList<>();

        Restaurant res = setItem();
        res.setName("KSM Ezyfood");
        res.setLongitude(106.607116);
        res.setLatitude(-6.226818);
        restaurants.add(res);
        Restaurant res2 = setItem();
        res2.setName("NS Ezyfood");
        res2.setLongitude(106.789986);
        res2.setLatitude(-6.174615);
        restaurants.add(res2);
        Restaurant res3 = setItem();
        res3.setName("TA Ezyfood");
        res3.setLongitude(106.79213);
        res3.setLatitude(-6.178674);
        restaurants.add(res3);
        Restaurant res4 = setItem();
        res4.setName("LW Ezyfood");
        res4.setLongitude(106.652868);
        res4.setLatitude(-6.244824);
        restaurants.add(res4);
        Restaurant res5 = setItem();
        res5.setName("BXC Ezyfood");
        res5.setLongitude(106.727875);
        res5.setLatitude(-6.285743);
        restaurants.add(res5);
    }
}
