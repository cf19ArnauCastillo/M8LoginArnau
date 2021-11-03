package com.example.LoginArnau.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.LoginArnau.DB.SongsDBHelper;
import com.example.LoginArnau.Model.Song;
import com.example.LoginArnau.R;
import com.example.LoginArnau.RecyclerViewAdapter;

import java.util.ArrayList;

public class FormFragment extends Fragment {
    private SongsDBHelper dbHelper;
    private SQLiteDatabase db;

    public FormFragment(){

    }

    public FormFragment(SongsDBHelper dbHelper, SQLiteDatabase db){
        this.dbHelper = dbHelper;
        this.db = db;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View formview = inflater.inflate(R.layout.fragment_form, container, false);

        //Declarations
        Button button = formview.findViewById(R.id.btnGuardar);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText textsong = formview.findViewById(R.id.textsong);

                Song s = new Song(textsong.getText().toString());
                Log.i("aqui",textsong.getText().toString());
                dbHelper.insertSong(db, s);

            }
        });
        //recoges los valores del formulario
        //Creas el objeto song
        //añades el objeto song a la db
        //EditText textsong = formview.findViewById(R.id.textsong);
        //Song s = new Song(textsong.getText().toString());
        //dbHelper.insertSong(db, s);

        return formview;
    }
}