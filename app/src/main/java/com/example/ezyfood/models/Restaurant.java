package com.example.ezyfood.models;

import com.example.ezyfood.interfaces.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurant implements Serializable {
    private String name;
    private ArrayList<Item> foods, drinks,  snacks;
    private double latitude, longitude;

    public void setName(String name) {
        this.name = name;
    }

    public void setFoods(ArrayList<Item> foods) {
        this.foods = foods;
    }

    public void setDrinks(ArrayList<Item> drinks) {
        this.drinks = drinks;
    }

    public void setSnacks(ArrayList<Item> snacks) {
        this.snacks = snacks;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getFoods() {
        return foods;
    }

    public ArrayList<Item> getDrinks() {
        return drinks;
    }

    public ArrayList<Item> getSnacks() {
        return snacks;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Restaurant(String name, double latitude, double longitude, ArrayList<Item> foods, ArrayList<Item> drinks,ArrayList<Item> snacks){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.foods = foods;
        this.drinks = drinks;
        this.snacks = snacks;
    }

    public Restaurant(){}
}
