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
import com.example.ezyfood.adapters.ListOrderAdapter;
import com.example.ezyfood.data.Carts;
import com.example.ezyfood.models.Cart;

public class TransactionHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        long money = MapsActivity.money;
        MapsActivity.money = money - Carts.getTotalPayment();
        init();
    }

    @SuppressLint("SetTextI18n")
    private void init(){
        Button mainMenuButton = findViewById(R.id.main_menu_button);
        TextView totalPaymentText = findViewById(R.id.total_payment2);
        totalPaymentText.setText("Rp. " + Carts.getTotalPayment());
        getSupportActionBar().setTitle(R.string.carts);
        RecyclerView recyclerView = findViewById(R.id.order_item_list);
        mainMenuButton.setOnClickListener(v -> {
            Intent i  = new Intent(TransactionHistory.this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Carts.clearCart();
            startActivity(i);
            this.finish();
        });
        ListOrderAdapter listOrderAdapter = new ListOrderAdapter(Carts.getListCart());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listOrderAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}