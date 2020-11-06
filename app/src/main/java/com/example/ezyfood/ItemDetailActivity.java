package com.example.ezyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezyfood.data.Carts;
import com.example.ezyfood.interfaces.Item;
import com.example.ezyfood.models.Cart;

public class ItemDetailActivity extends AppCompatActivity {

    private ImageView itemPicture;
    private TextView itemNameText, itemDescriptionText, itemPriceText, itemQuantityText;
    private Button addToCartButton,  plusButton, minusButton;
    private Integer quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }

    private  void init(){
        Bundle extras = getIntent().getExtras();
        Item item = (Item) extras.getSerializable("item");
        getSupportActionBar().setTitle(item.getName());
        itemPicture = findViewById(R.id.item_detail_pic);
        itemNameText = findViewById(R.id.item_detail_name);
        itemDescriptionText = findViewById(R.id.item_detail_description);
        itemPriceText = findViewById(R.id.item_detail_price);
        itemQuantityText = findViewById(R.id.item_detail_quantity);
        addToCartButton = findViewById(R.id.add_to_cart_button);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        CardView orderMoreButton = findViewById(R.id.order_more_button);
        orderMoreButton.setOnClickListener(v -> finish());
        setData(item);
    }

    @SuppressLint("SetTextI18n")
    private void setData(Item item){
        itemPicture.setImageResource(item.getPicID());
        itemNameText.setText(item.getName());
        itemDescriptionText.setText(item.getDescription());
        itemPriceText.setText("Rp. " + item.getPrice());
        int checkIndex = Carts.findIndex(item);
        if(checkIndex != -1) {
            addToCartButton.setText(R.string.update_quantity);
            quantity = Carts.getListCart().get(checkIndex).getQuantity();
        }
        else quantity = 1;
        itemQuantityText.setText(quantity+"");
        setQuantity();
        addToCartButton.setOnClickListener(v -> {
            int check = Carts.findIndex(item);
            boolean checkCart = Carts.findCart(item);
            if(checkCart && check != -1)
                Carts.getListCart().get(check).setQuantity(quantity);
            else {
                Cart cart = new Cart(item, quantity);
                Carts.addCart(cart);
            }
            addToCartButton.setText(R.string.update_quantity);
            Toast.makeText(this, "Add To Cart Success", Toast.LENGTH_SHORT).show();
        });
    }

    @SuppressLint("SetTextI18n")
    private void setQuantity(){
        plusButton.setOnClickListener(v -> {
            quantity +=1;
            itemQuantityText.setText(quantity.toString());
        });
        minusButton.setOnClickListener(v -> {
            if(quantity == 1) return;
            quantity -=1;
            itemQuantityText.setText(quantity.toString());
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.shopping_cart_menu){
            startActivity(new Intent(ItemDetailActivity.this, ShoppingCartActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}