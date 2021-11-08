package com.example.LoginArnau;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LoginArnau.Model.Song;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Song> array_songs;

    public RecyclerViewAdapter(ArrayList<Song> arrN){
        array_songs = arrN;
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
        holder.userName.setText(array_songs.get(position).getNombre());
    }

    // It tells us how many items it will need to iterate from the list
    @Override
    public int getItemCount() {
        return array_songs.size();
    }

    // Link items in the item_list to the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
        }
    }
}

