package com.milli.ontime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationActivity extends AppCompatActivity {
    private Button z;
    private Button y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        z = (Button) findViewById(R.id.student_but);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openstudentreg();
            }
        });
        y = (Button) findViewById(R.id.facult_but);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfacultyreg();
            }
        });
    }

    public void openstudentreg() {
        Intent z = new Intent(RegistrationActivity.this, StudentRegistrationActivity.class);
        startActivity(z);
    }
    public void openfacultyreg(){
        Intent y = new Intent(RegistrationActivity.this, FacultyRegistrationActivity.class);
        startActivity(y);
    }
}

