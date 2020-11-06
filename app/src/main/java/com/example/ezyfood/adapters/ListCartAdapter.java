package com.example.ezyfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;
import com.example.ezyfood.models.Cart;

import java.util.ArrayList;

public class ListCartAdapter  extends RecyclerView.Adapter<ListViewCartHolder>{

    private final ArrayList<Cart> listCart;

    public ListCartAdapter(ArrayList<Cart> list){
        this.listCart = list;
    }

    @NonNull
    @Override
    public ListViewCartHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_row, viewGroup, false);
        return new ListViewCartHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewCartHolder holder, int position) {
        holder.setItem(listCart.get(position));
    }

    @Override
    public int getItemCount() {
        return listCart.size();
    }
}
