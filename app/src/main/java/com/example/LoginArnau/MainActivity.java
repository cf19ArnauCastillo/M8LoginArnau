package com.example.LoginArnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
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


        //Here we create a function for the button "login" so when you login with your credentials it works
        final Button login = findViewById(R.id.btnSignIn);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txtUsername.getText().toString().equals("admin")&&(txtPassword.getText().toString().equals("admin"))){
                    Log.i("Test", "Login correcte");
                    ok.setText("Login Correcte");
                    goToHomeActivity();
                    //startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                }else{
                    Log.i("Test", "Login incorrecte");
                    ok.setText("Login Incorrecte");
                }
            }
        });
    }

    public void goToHomeActivity() {
        Intent intentHome = new Intent(this, HomeActivity.class);
        startActivity(intentHome);
    }
}