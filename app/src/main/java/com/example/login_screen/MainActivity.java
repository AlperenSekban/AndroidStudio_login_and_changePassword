package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginBtn;
    TextView userNameTxt,passwordTxt;
    String userName="admin";
    String password="User123!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn =(Button) findViewById(R.id.loginBtn);
        userNameTxt =(TextView) findViewById(R.id.userNameTxt);
        passwordTxt=(TextView) findViewById(R.id.passwordTxt);

        Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            password=bundle.getString("password");
            ;
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userNameTxt.getText().toString().equals(userName)&& passwordTxt.getText().toString().equals(password)){
                    Intent intent=new Intent(MainActivity.this,PasswordChangeScreen.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Kullanıcı adı veya şifrenizi yanlış girdiniz...",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }





}
