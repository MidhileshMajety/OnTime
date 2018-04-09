package com.milli.ontime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StudentLoginActivity extends AppCompatActivity {

    private EditText EnrollmentNumber;
    private EditText Password;
    private Button LogIn;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        EnrollmentNumber = (EditText)findViewById(R.id.enrollmentno);
        Password = (EditText)findViewById(R.id.password);
        LogIn= (Button)findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null) {
            finish();
            startActivity(new Intent(StudentLoginActivity.this , StudentRegistrationActivity.class));
        }
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(EnrollmentNumber.getText().toString(), Password.getText().toString());
            }
        });


    }

    private void validate(String EnrollmentNumber, String Password){

        progressDialog.setMessage("You can use this until you are verified");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(EnrollmentNumber,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()){
                  progressDialog.dismiss();
                  Toast.makeText(StudentLoginActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(StudentLoginActivity.this,StudentRegistrationActivity.class));
              }else{
                  Toast.makeText(StudentLoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
              }
            }
        });
    }
}
