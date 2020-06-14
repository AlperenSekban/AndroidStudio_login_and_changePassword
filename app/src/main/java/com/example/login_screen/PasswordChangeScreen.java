package com.example.login_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PasswordChangeScreen extends AppCompatActivity {
    Button passwordChangeBtn;
    TextView passwordChangeTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change_screen);

        passwordChangeBtn=(Button) findViewById(R.id.passwordChangeBtn);
        passwordChangeTxt=(TextView) findViewById(R.id.passwordChangeTxt);

        passwordChangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passwordChangeTxt.getText().toString().length()<6){
                    Toast.makeText(getApplicationContext(),"Şifreniz minimum 6 karakter içermek zorundadır",Toast.LENGTH_SHORT).show();
                }
                if(!(IsTherePunctuation(passwordChangeTxt.getText().toString()))){
                    Toast.makeText(getApplicationContext(),"Şifreniz noktalama işareti içermek zorundadır",Toast.LENGTH_SHORT).show();
                }
                if(!(IsThereUpperLatter(passwordChangeTxt.getText().toString()))){
                    Toast.makeText(getApplicationContext(),"Şifreniz büyük harf içermek zorundadır",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(PasswordChangeScreen.this,MainActivity.class);
                    intent.putExtra("password",passwordChangeTxt.getText().toString());
                    startActivity(intent);
                }
            }


        });



    }
    public boolean IsTherePunctuation(String password){
        int flag=0;
        for(int i=0;i<password.length();i++){
            if ((password.charAt(i)>32 && password.charAt(i)<48) || (password.charAt(i)>57 && password.charAt(i)<65) || (password.charAt(i)>90 && password.charAt(i)<97) || (password.charAt(i)>122 && password.charAt(i)<127)){
                flag++;

            }
        }
        return (flag>0);
    }

    public boolean IsThereUpperLatter(String password){
        int flag=0;
        for(int i=0;i<password.length();i++){
            if ((password.charAt(i)>64 && password.charAt(i)<91)){
                flag++;

            }
        }
        return (flag>0);

    }
}