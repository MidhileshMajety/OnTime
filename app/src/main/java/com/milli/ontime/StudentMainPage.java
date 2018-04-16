package com.milli.ontime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class StudentMainPage extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button LogOut;
    private Button Check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main_page);
        firebaseAuth = FirebaseAuth.getInstance();
        LogOut = (Button)findViewById(R.id.logOut);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(StudentMainPage.this,LoginRegistrationActivity.class));

            }
        });


    }
}
