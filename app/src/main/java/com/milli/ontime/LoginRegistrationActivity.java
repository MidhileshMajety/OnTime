package com.milli.ontime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginRegistrationActivity extends AppCompatActivity {
private Button b;
private Button c;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registration);


        b = (Button)findViewById(R.id.create_account);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginRegistrationActivity.this,RegistrationActivity.class);
                startActivity(i);
            }
        });

        c = (Button)findViewById(R.id.login);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openloginpage();
            }
        });

    }
    public void openloginpage(){
    Intent j = new Intent(LoginRegistrationActivity.this, LoginActivity.class);
    startActivity(j);
    }
}
