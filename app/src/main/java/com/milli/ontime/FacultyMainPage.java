package com.milli.ontime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class FacultyMainPage extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button LOGOUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_main_page);
        firebaseAuth = FirebaseAuth.getInstance();
        LOGOUT = (Button)findViewById(R.id.logout);
        LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(FacultyMainPage.this,LoginRegistrationActivity.class));
            }
        });
    }
}
