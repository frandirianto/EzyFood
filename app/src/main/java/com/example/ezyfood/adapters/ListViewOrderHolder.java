package com.example.ezyfood.adapters;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;
import com.example.ezyfood.models.Cart;

public class ListViewOrderHolder extends RecyclerView.ViewHolder {


    private final ImageView itemPicture;
    private final TextView itemNameText, itemDescriptionText, itemPriceText, itemSubtotalText, itemQuantityText;

    public ListViewOrderHolder(@NonNull View itemView) {
        super(itemView);
        itemPicture = itemView.findViewById(R.id.order_item_picture);
        itemNameText = itemView.findViewById(R.id.order_item_name);
        itemDescriptionText = itemView.findViewById(R.id.order_item_description);
        itemPriceText = itemView.findViewById(R.id.order_item_price);
        itemSubtotalText = itemView.findViewById(R.id.order_item_subtotal);
        itemQuantityText = itemView.findViewById(R.id.order_item_quantity);
    }

    @SuppressLint("SetTextI18n")
    public void setItem(Cart cart){
        itemPicture.setImageResource(cart.getItem().getPicID());
        itemNameText.setText(cart.getItem().getName());
        itemDescriptionText.setText(cart.getItem().getDescription());
        itemPriceText.setText("Rp. " + cart.getItem().getPrice());
        itemQuantityText.setText(""+cart.getQuantity());
        itemSubtotalText.setText("Rp. " + (cart.getQuantity()* cart.getItem().getPrice()));
    }
}
