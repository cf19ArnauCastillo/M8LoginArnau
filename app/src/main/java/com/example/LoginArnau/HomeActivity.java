package com.example.LoginArnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.LoginArnau.DB.SongsDBHelper;
import com.example.LoginArnau.Fragments.FormFragment;
import com.example.LoginArnau.Fragments.FragmentHome;
import com.example.LoginArnau.Fragments.ListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    //Create the instance of dbHelper
    private SongsDBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Creation of the dbHelper
        dbHelper = new SongsDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        //Here we make that the bottom navigation down the app it works and you can actually pass to other pages
        BottomNavigationView bottomNav = findViewById(R.id.main_menu);

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;

                case R.id.nav_list:
                    selectedFragment = new ListFragment();
                    break;

                case R.id.nav_add:
                    selectedFragment = new FormFragment(dbHelper, db);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });
    }

    //Close the db when the activity onDestroy
    @Override
    protected void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}