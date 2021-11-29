package com.example.LoginArnau.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.LoginArnau.R;

import java.util.Locale;

public class FragmentHome extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewHome = inflater.inflate(R.layout.fragment_home, container, false);
        Button English = viewHome.findViewById(R.id.english);
        Button Espanol = viewHome.findViewById(R.id.espanol);
        Button Catala = viewHome.findViewById(R.id.catala);

        English.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Change("En");
            }
        });

        Espanol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Change("Es");
            }
        });

        Catala.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Change("Ca");
            }
        });

        return viewHome;
    }
    public void Change(String locale){
        SharedPreferences preferences = getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        final Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Idioma",locale );
        editor.commit();
    }
}