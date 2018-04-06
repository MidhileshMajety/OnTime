package com.milli.ontime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private Button k;
    private Button m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

     k = (Button) findViewById(R.id.student_but);
     k.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        openstudentlogin();
    }
});
     m = (Button) findViewById(R.id.facult_but);
     m.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             openfacultylogin();
         }
     });
    }
    public void openstudentlogin(){
        Intent k = new Intent(LoginActivity.this,StudentLoginActivity.class);
        startActivity(k);
    }
    public void openfacultylogin(){
        Intent m = new Intent(LoginActivity.this,FacultyLoginActivity.class);
        startActivity(m);
    }
}
