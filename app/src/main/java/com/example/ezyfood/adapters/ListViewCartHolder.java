package com.example.ezyfood.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;
import com.example.ezyfood.data.Carts;
import com.example.ezyfood.models.Cart;

public class ListViewCartHolder extends RecyclerView.ViewHolder {

    private final ImageView itemPicture;
    private final TextView itemNameText, itemDescriptionText, itemPriceText, itemSubtotalText, itemQuantityText;
    private final ImageButton deleteCartButton;
    private  RecyclerView.Adapter adapter;

    ListViewCartHolder(@NonNull final View itemView, RecyclerView.Adapter adapter) {
        super(itemView);
        this.adapter = adapter;
        itemPicture = itemView.findViewById(R.id.cart_item_picture);
        itemNameText = itemView.findViewById(R.id.cart_item_name);
        itemDescriptionText = itemView.findViewById(R.id.cart_item_description);
        itemPriceText = itemView.findViewById(R.id.cart_item_price);
        itemSubtotalText = itemView.findViewById(R.id.cart_item_subtotal);
        itemQuantityText = itemView.findViewById(R.id.cart_item_quantity);
        deleteCartButton = itemView.findViewById(R.id.cart_delete_button);
    }

    @SuppressLint("SetTextI18n")
    public void setItem(Cart cart, Context c){
        itemPicture.setImageResource(cart.getItem().getPicID());
        itemNameText.setText(cart.getItem().getName());
        itemDescriptionText.setText(cart.getItem().getDescription());
        itemPriceText.setText("Rp. " + cart.getItem().getPrice());
        itemQuantityText.setText(""+cart.getQuantity());
        itemSubtotalText.setText("Rp. " + (cart.getQuantity()*cart.getItem().getPrice()));
        deleteCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carts.removeCart(cart);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
