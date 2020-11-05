package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.ezyfood.adapters.ListCartAdapter;
import com.example.ezyfood.data.Carts;

public class ShoppingCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
        Carts.subscribe(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private void init(){
        getSupportActionBar().setTitle(R.string.carts);
        RecyclerView recyclerView = findViewById(R.id.cart_item_list);
        ListCartAdapter listCartAdapter = new ListCartAdapter(this, Carts.getListCart());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listCartAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Carts.unsubscribe();
    }
}