package com.example.ezyfood.data;

import com.example.ezyfood.interfaces.Item;
import com.example.ezyfood.models.Cart;

import java.util.ArrayList;

public class Carts {

    private static Runnable runnable;
    private static ArrayList<Cart> listCart = new ArrayList<>();

    public static void addCart(Cart cart){
        listCart.add(cart);
        update();
    }

    public static void update(){
        if(runnable != null)
        runnable.run();
    }

    public static void removeCart(Cart cart){
        listCart.remove(findIndex(cart.getItem()));
        update();
    }

    public static boolean findCart(Item item){
        for(int i = 0; i < listCart.size(); i++)
            if(item.getName().equals(listCart.get(i).getItem().getName())) return true;
        return false;
    }

    public static int findIndex(Item item){
        for(int i = 0; i < listCart.size(); i++){
            if(item.getName().equals(listCart.get(i).getItem().getName())) return i;
        }
        return  -1;
    }

    public  static int getTotalPayment(){
        int totalPayment = 0;
        if(listCart.size() != 0) {
            for (Cart cart :
                    listCart) {
                totalPayment += (cart.getItem().getPrice() * cart.getQuantity());
            }
        }
        return totalPayment;
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

    public static void clearCart(){
        listCart = new ArrayList<>();
    }
}
