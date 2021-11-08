package com.example.LoginArnau.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.LoginArnau.DB.SongsDBHelper;
import com.example.LoginArnau.Model.Song;
import com.example.LoginArnau.R;

public class FormFragment extends Fragment {
    private SongsDBHelper dbHelper;
    private SQLiteDatabase db;

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
        Button borrar = formview.findViewById(R.id.btnBorrar);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText textsong = formview.findViewById(R.id.textsong);
                EditText textartist = formview.findViewById(R.id.textartist);

                Song s = new Song(textsong.getText().toString(),textartist.getText().toString());
;
                dbHelper.insertSong(db, s);

            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dbHelper.delete();
                //dbHelper.dropTable(db);
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