package com.example.ezyfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ezyfood.R;
import com.example.ezyfood.interfaces.Item;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListViewItemHolder>{

    private final ArrayList<Item> listItem;
    private final Context c;
    private final Class targetClass;

    public ListItemAdapter(Context c, Class targetClass, ArrayList<Item> list){
        this.c = c;
        this.targetClass = targetClass;
        this.listItem = list;
    }

    @NonNull
    @Override
    public ListViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new ListViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewItemHolder holder, int position) {
        holder.setItem(listItem.get(position), c, targetClass);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
}
