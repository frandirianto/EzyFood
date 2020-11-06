package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ezyfood.adapters.ListCartAdapter;
import com.example.ezyfood.data.Carts;

import java.util.Objects;

public class ShoppingCartActivity extends AppCompatActivity {

    private TextView totalPaymentText, emptyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        init();
    }

    @SuppressLint("SetTextI18n")
    private void init(){
        Button payButton = findViewById(R.id.pay_button);
        emptyText = findViewById(R.id.empty_cart_text);
        totalPaymentText = findViewById(R.id.total_payment);
        totalPaymentText.setText("Rp. " + Carts.getTotalPayment());
        payButton.setOnClickListener(v -> startActivity(new Intent(ShoppingCartActivity.this, TransactionHistory.class)));
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.carts);
        RecyclerView recyclerView = findViewById(R.id.cart_item_list);
        ListCartAdapter listCartAdapter = new ListCartAdapter(Carts.getListCart());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listCartAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();
        Carts.subscribe(() -> {
            if(Carts.getListCart().size() == 0) emptyText.setVisibility(View.VISIBLE);
            totalPaymentText.setText("Rp. " + Carts.getTotalPayment());
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Carts.unsubscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Carts.unsubscribe();
    }
}