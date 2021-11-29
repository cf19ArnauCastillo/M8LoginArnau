package com.example.LoginArnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.LoginArnau.DB.SongsDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    int comprobacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Here we create the id of the buttons, edittexts, textview so we cant use it in files.java in our app
        Button btnSignIn = findViewById(R.id.btnSignIn);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);
        TextView ok = findViewById(R.id.ok);
        CheckBox checkBox=findViewById(R.id.checkBox);

        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        comprobacion = (preferences.getInt("comprobante", 0));

        if (comprobacion != 0) {
            txtUsername.setText(preferences.getString("Username", ""));
            txtPassword.setText(preferences.getString("Password", ""));
            String txtUsernameF = txtUsername.getText().toString();
            String txtPasswordF = txtPassword.getText().toString();

            if (txtUsernameF.equals("admin") && txtPasswordF.equals("admin")) {
                goToHomeActivity();
            }

        }

        //Here we create a function for the button "login" so when you login with your credentials it works
        final Button login = findViewById(R.id.btnSignIn);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Get the data from the edit text and pass it to a string and then save it in a variable string
                String txtUsernameF = txtUsername.getText().toString();
                String txtPasswordF = txtPassword.getText().toString();
                //If the user is admin and the password is admin, you will enter the if
                if (checkBox.isChecked()==true){
                    guardarPreferencias();
                }
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

    private void guardarPreferencias() {
        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Username", ((EditText) findViewById(R.id.txtUsername)).getText().toString());
        editor.putString("Password", ((EditText) findViewById(R.id.txtPassword)).getText().toString());
        editor.putInt("comprobante", 1);
        editor.commit();
    }
}