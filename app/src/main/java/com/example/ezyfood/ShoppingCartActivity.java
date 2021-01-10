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
import android.widget.Toast;

import com.example.ezyfood.adapters.ListCartAdapter;
import com.example.ezyfood.data.Carts;

import java.util.Objects;

public class ShoppingCartActivity extends AppCompatActivity {

    private TextView totalPaymentText, emptyText, balanceText;

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
        balanceText = findViewById(R.id.textView7);
        totalPaymentText = findViewById(R.id.total_payment);
        long money =  MapsActivity.money;
        balanceText.setText("Cash : Rp. " +money );
        int total =Carts.getTotalPayment();
        totalPaymentText.setText("Rp. " + total);
        payButton.setOnClickListener(v -> {
            if(money < total)  Toast.makeText(ShoppingCartActivity.this, "Can't pay, you must top up",Toast.LENGTH_LONG).show();
            else startActivity(new Intent(ShoppingCartActivity.this, TransactionHistory.class));
        });
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