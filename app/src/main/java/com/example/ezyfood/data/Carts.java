package com.example.ezyfood.data;

import com.example.ezyfood.models.Cart;

import java.util.ArrayList;

public class Carts {

    private static Runnable runnable;
    private final static ArrayList<Cart> listCart = new ArrayList<>();

    public static void addCart(Cart cart){
        listCart.add(cart);
        update();
    }

    public static void update(){
        if(runnable != null)
        runnable.run();
    }

    public static void removeCart(Cart cart){
        listCart.remove(cart);
        update();
    }

    public static ArrayList<Cart> getListCart(){
        return  listCart;
    }

    public static void subscribe(Runnable runnableParam){
        runnable = runnableParam;
    }

    public static void unsubscribe(){
        runnable = null;
    }
}
