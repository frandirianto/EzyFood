package com.example.ezyfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TopUpActivity extends AppCompatActivity {

    private TextView balance;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.top_up);
        init();
    }

    private void init(){
        balance = findViewById(R.id.user_money);
        editText =findViewById(R.id.editText);
        Button topUpBtn = findViewById(R.id.top_up_button2);

        String money = "Cash : Rp." + MapsActivity.money;
        balance.setText(money);
        topUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topUp();
            }
        });
    }

    private void topUp(){
        long amount = Integer.parseInt(editText.getText()+"");
        if(amount > 2000000){
            Toast.makeText(TopUpActivity.this, "Can't more than Rp. 2.000.000",Toast.LENGTH_LONG).show();
        }
        else {
            long money2 = MapsActivity.money;
            MapsActivity.money = money2+amount;
            Toast.makeText(TopUpActivity.this, "Top Up Success",Toast.LENGTH_LONG).show();
            String money = "Cash : Rp." + MapsActivity.money;
            balance.setText(money);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
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
            startActivity(new Intent(TopUpActivity.this, ShoppingCartActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}