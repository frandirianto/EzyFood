package com.example.ezyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ezyfood.adapters.ListItemAdapter;
import com.example.ezyfood.interfaces.ItemType;
import com.example.ezyfood.models.Restaurant;

import java.util.Objects;

public class ItemsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }

    private void init(){
        Bundle extras = getIntent().getExtras();
        Restaurant res = (Restaurant) extras.getSerializable("restaurant");
        ItemType type = (ItemType) extras.getSerializable("types");

        recyclerView = findViewById(R.id.item_list);
        setData(res, type);
    }

    private void setData(Restaurant res, ItemType type){
        ListItemAdapter listAdapter;

        switch (type){
            case FOOD:
                getSupportActionBar().setTitle(R.string.foods);
                listAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, res.getFoods());
                break;
            case DRINK:
                getSupportActionBar().setTitle(R.string.drinks);
                listAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, res.getDrinks());
                break;
            case SNACK:
                getSupportActionBar().setTitle(R.string.snacks);
                listAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, res.getSnacks());
                break;
            default:
                getSupportActionBar().setTitle(R.string.app_name);
                listAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, res.getFoods());
                break;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.shopping_cart_menu){
            startActivity(new Intent(ItemsActivity.this, ShoppingCartActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}