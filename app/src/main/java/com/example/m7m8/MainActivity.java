package com.example.m7m8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSignIn = findViewById(R.id.btnSignIn);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);
        TextView ok = findViewById(R.id.ok);

        final Button login = findViewById(R.id.btnSignIn);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txtUsername.getText().toString().equals("123")){
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