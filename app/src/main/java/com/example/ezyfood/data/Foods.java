package com.example.ezyfood.data;

import com.example.ezyfood.R;
import com.example.ezyfood.interfaces.Item;
import com.example.ezyfood.models.Food;

import java.util.ArrayList;

public class Foods {
    private static ArrayList<Item> listFood;

    private static void setRecommendedFoodsData(){
        listFood.add(new Food(R.drawable.pic_ayam_bakar, "Ayam Bakar Spesial", "Ayam Bakar 1 ekor",15000));
        listFood.add(new Food(R.drawable.pic_gurami_goreng, "Gurami Goreng Asin", "Gurami Goreng 1 ekor",20000));
        listFood.add(new Food(R.drawable.pic_gurami_bakar, "Gurami Bakar", "Gurami Bakar 1 ekor",20000));
    }

    private static void setTopSellingFoodsData(){
        listFood.add(new Food(R.drawable.pic_nasi_goreng, "Nasi Goreng Spesial", "Nasi Goreng + Telur + Daging Sapi",120000));
        listFood.add(new Food(R.drawable.pic_kwetiau, "Kwetiau Spesial", "Kwetiau Kuah + Pangsit Rebus",18000));
        listFood.add(new Food(R.drawable.pic_sate_ayam, "Sate Ayam", "Sate Ayam 15 tusuk",15000));
        listFood.add(new Food(R.drawable.pic_cumi_goreng, "Cumi Goreng", "Cumi Goreng Krispi + Sambal",20000));
        listFood.add(new Food(R.drawable.pic_mie_ayam, "Mie Ayam", "Mie Ayam + Pangsit Goreng",12000));
        listFood.add(new Food(R.drawable.pic_ayam_goreng, "Ayam Goreng", "Ayam Goreng 1/2 ekor + Lalap",13000));
        listFood.add(new Food(R.drawable.pic_soto, "Soto Ayam", "Soto Ayam + Emping",10000));
        listFood.add(new Food(R.drawable.pic_udang_renyah, "Udang Renyah", "Udang Goreng Krispi + Saus",20000));
    }
    public static ArrayList<Item> getRecommendedFoods() {
        listFood = new ArrayList<>();
        setRecommendedFoodsData();
        return listFood;
    }

    public static ArrayList<Item> getTopSellingFoods() {
        listFood = new ArrayList<>();
        setTopSellingFoodsData();
        return listFood;
    }
}
