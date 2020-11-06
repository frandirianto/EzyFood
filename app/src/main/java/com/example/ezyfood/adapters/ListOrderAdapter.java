package com.example.ezyfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;
import com.example.ezyfood.models.Cart;

import java.util.ArrayList;

public class ListOrderAdapter extends RecyclerView.Adapter<ListViewOrderHolder> {

    private final ArrayList<Cart> listOrder;

    public ListOrderAdapter(ArrayList<Cart> listOrder){
        this.listOrder = listOrder;
    }

    @NonNull
    @Override
    public ListViewOrderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_row, viewGroup, false);
        return new ListViewOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewOrderHolder holder, int position) {
        holder.setItem(listOrder.get(position));
    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }
}
