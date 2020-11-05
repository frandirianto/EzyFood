package com.example.ezyfood.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;
import com.example.ezyfood.interfaces.Item;

public class ListViewItemHolder extends RecyclerView.ViewHolder{
    private final CardView itemCard;
    private final ImageView itemPicture;
    private final TextView itemNameText, itemDescriptionText, itemPriceText;

    ListViewItemHolder(@NonNull final View itemView) {
        super(itemView);
        itemCard = itemView.findViewById(R.id.item_card);
        itemPicture = itemView.findViewById(R.id.item_pic);
        itemNameText = itemView.findViewById(R.id.item_name);
        itemDescriptionText = itemView.findViewById(R.id.item_description);
        itemPriceText = itemView.findViewById(R.id.item_price);
    }

    @SuppressLint("SetTextI18n")
    public void setItem(Item item, Context c, Class targetClass){
        itemPicture.setImageResource(item.getPicID());
        itemNameText.setText(item.getName());
        itemDescriptionText.setText(item.getDescription());
        itemPriceText.setText("Rp. " + item.getPrice());
        itemCard.setOnClickListener(v -> {
            Intent i = new Intent(c, targetClass);
            i.putExtra("item",item);
            c.startActivity(i);
        });
    }
}
