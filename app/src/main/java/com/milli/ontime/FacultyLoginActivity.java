package com.milli.ontime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FacultyLoginActivity extends AppCompatActivity {

    private EditText FacultyID;
    private EditText Password;
    private Button LOGIN;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);

        FacultyID = (EditText)findViewById(R.id.facultyid);
        Password = (EditText)findViewById(R.id.password);
        LOGIN = (Button)findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null) {
            finish();
            startActivity(new Intent(FacultyLoginActivity.this , FacultyRegistrationActivity.class));
           }
           LOGIN.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   validate(FacultyID.getText().toString() , Password.getText().toString());
               }
           });
        }
        private void validate(String FacultyID , String Password){

        progressDialog.setMessage("You can use this until you are verified");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(FacultyID , Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(FacultyLoginActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FacultyLoginActivity.this , StudentLoginActivity.class));
                }else{
                    Toast.makeText(FacultyLoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        }
}
