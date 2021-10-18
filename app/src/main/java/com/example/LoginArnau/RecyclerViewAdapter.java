package com.example.LoginArnau;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> array_noms;

    public RecyclerViewAdapter(ArrayList<String> arrN){
        array_noms = arrN;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    // Adds content to declared items in the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(array_noms.get(position));
    }

    // It tells us how many items it will need to iterate from the list
    @Override
    public int getItemCount() {
        return array_noms.size();
    }

    // Link items in the item_list to the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userName);
        }
    }
}

