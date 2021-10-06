package com.example.LoginArnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Here we create the id of the buttons, edittexts, textview so we cant use it in files.java in our app
        Button btnSignIn = findViewById(R.id.btnSignIn);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);
        TextView ok = findViewById(R.id.ok);
        BottomNavigationView bottomNav = findViewById(R.id.main_menu);

        //Here we make that the bottom navigation down the app it works and you can actually pass to other pages
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
                    selectedFragment = new FormFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });

        //Here we create a function for the button "login" so when you login with your credentials it works
        final Button login = findViewById(R.id.btnSignIn);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txtUsername.getText().toString().equals("admin")&&(txtPassword.getText().toString().equals("admin"))){
                    Log.i("Test", "Login correcte");
                    ok.setText("Login Correcte");
                }else{
                    Log.i("Test", "Login incorrecte");
                    ok.setText("Login Incorrecte");
                }
            }
        });
    }
}