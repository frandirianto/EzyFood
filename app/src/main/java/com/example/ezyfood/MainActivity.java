package com.example.ezyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.ezyfood.interfaces.ItemType;
import com.example.ezyfood.models.Restaurant;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity  {


    FrameLayout snacksButton, foodsButton, drinksButton, topUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        init();
    }

    void init(){
        Bundle extras = getIntent().getExtras();
        Restaurant restaurant = MapsActivity.temp;
        getSupportActionBar().setTitle(restaurant.getName());
        foodsButton = findViewById(R.id.foods_button);
        drinksButton = findViewById(R.id.drinks_button);
        snacksButton = findViewById(R.id.snacks_button);
        topUpButton = findViewById(R.id.top_up_button);

        foodsButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ItemsActivity.class);
            i.putExtra("restaurant", (Serializable) restaurant);
            i.putExtra("types", ItemType.FOOD);
            startActivity(i);
        });
        drinksButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ItemsActivity.class);
            i.putExtra("restaurant", (Serializable) restaurant);
            i.putExtra("types", ItemType.DRINK);
            startActivity(i);
        });
        snacksButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ItemsActivity.class);
            i.putExtra("restaurant", (Serializable) restaurant);
            i.putExtra("types", ItemType.SNACK);
            startActivity(i);
        });

        topUpButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, TopUpActivity.class);
            startActivity(i);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.shopping_cart_menu){
            startActivity(new Intent(MainActivity.this, ShoppingCartActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }
}