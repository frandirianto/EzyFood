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
import com.example.ezyfood.data.Foods;
import com.example.ezyfood.interfaces.ItemType;

public class ItemsActivity extends AppCompatActivity {

    private RecyclerView recyclerView, recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }

    private void init(){
        Bundle extras = getIntent().getExtras();
        ItemType type = (ItemType) extras.getSerializable("types");

        recyclerView = findViewById(R.id.recommended_item_list);
        recyclerView2 = findViewById(R.id.top_selling_item_list);
        setData(type);
    }

    private void setData(ItemType type){
        ListItemAdapter recommendedAdapter, topSellingAdapter;

        switch (type){
            case FOOD:
                getSupportActionBar().setTitle(R.string.foods);
                recommendedAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getRecommendedFoods());
                topSellingAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getTopSellingFoods());
                break;
            case DRINK:
                getSupportActionBar().setTitle(R.string.drinks);
                recommendedAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getRecommendedFoods());
                topSellingAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getRecommendedFoods());
                break;
            case SNACK:
                getSupportActionBar().setTitle(R.string.snacks);
                recommendedAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getRecommendedFoods());
                topSellingAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getRecommendedFoods());
                break;
            default:
                getSupportActionBar().setTitle(R.string.app_name);
                recommendedAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getRecommendedFoods());
                topSellingAdapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getTopSellingFoods());
                break;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recommendedAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(topSellingAdapter);
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