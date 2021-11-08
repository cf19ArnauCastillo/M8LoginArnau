package com.example.LoginArnau.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.LoginArnau.DB.SongsDBHelper;
import com.example.LoginArnau.Model.Song;
import com.example.LoginArnau.R;
import com.example.LoginArnau.RecyclerViewAdapter;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private SongsDBHelper dbHelper;
    private SQLiteDatabase db;

    public ListFragment(SongsDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper = dbHelper;
        this.db = db;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View listview = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Song> arraySongs = dbHelper.getAllSongs(db);

        // Here we build the recycler view
        RecyclerView recyclerView = listview.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(arraySongs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        return listview;
    }
}