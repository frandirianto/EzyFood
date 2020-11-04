package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ezyfood.adapters.ListItemAdapter;
import com.example.ezyfood.data.Foods;
import com.example.ezyfood.interfaces.ItemType;

public class ItemsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        init();
    }

    private void init(){
        Bundle extras = getIntent().getExtras();
        ItemType type = (ItemType) extras.getSerializable("types");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.item_list);
        setData(type);
    }

    private void setData(ItemType type){
        ListItemAdapter adapter;

        switch (type){
            case FOOD:
                getSupportActionBar().setTitle(R.string.foods);
                adapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getListFood());
                break;
            case DRINK:
                getSupportActionBar().setTitle(R.string.drinks);
                adapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getListFood());
                break;
            case SNACK:
                getSupportActionBar().setTitle(R.string.snacks);
                adapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getListFood());
                break;
            default:
                getSupportActionBar().setTitle(R.string.app_name);
                adapter = new ListItemAdapter(ItemsActivity.this, ItemDetailActivity.class, Foods.getListFood());
                break;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}