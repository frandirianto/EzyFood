package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.ezyfood.data.Foods;
import com.example.ezyfood.interfaces.ItemType;

public class MainActivity extends AppCompatActivity {

    FrameLayout snacksButton, foodsButton, drinksButton, topUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
        foodsButton = findViewById(R.id.foods_button);
        drinksButton = findViewById(R.id.drinks_button);
        snacksButton = findViewById(R.id.snacks_button);
        topUpButton = findViewById(R.id.top_up_button);
        Foods.createFoodMenu();

        foodsButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ItemsActivity.class);
            i.putExtra("types", ItemType.FOOD);
            startActivity(i);
        });
        drinksButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ItemsActivity.class);
            i.putExtra("types", ItemType.DRINK);
            startActivity(i);
        });
        snacksButton.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ItemsActivity.class);
            i.putExtra("types", ItemType.SNACK);
            startActivity(i);
        });
        topUpButton.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Top Up Success",Toast.LENGTH_LONG).show());
    }
}