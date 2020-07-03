package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Button loginBtn;
    TextView userNameTxt, passwordTxt;
    String userName;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.activity_main_login_button);
        userNameTxt = findViewById(R.id.activity_main_username_textInputLayout);
        passwordTxt = findViewById(R.id.activitiy_main_password_textInputLayout);
        sharedPreferences = getApplicationContext().getSharedPreferences("saklas", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        userName = "admin";
        password = sharedPreferences.getString(Utility.password, "User123!");


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            editor.putString(Utility.password, bundle.getString(Utility.password, "User123!"));
            editor.commit();


        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userNameTxt.getText().toString().equals(userName) && passwordTxt.getText().toString().equals(password)) {
                    Intent intent = new Intent(MainActivity.this, PasswordChangeScreen.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), R.string.activity_main_toastMessage_wrongLogIn, Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


}
