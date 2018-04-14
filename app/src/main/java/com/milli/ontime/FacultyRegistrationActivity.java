package com.milli.ontime;

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

public class FacultyRegistrationActivity extends AppCompatActivity {
    private EditText name , password , facultymail ,facultyid, courseid;
    private Button Register;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_registration);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                  String EmailID=facultymail.getText().toString().trim();
                  String Password=password.getText().toString().trim();

                  firebaseAuth.createUserWithEmailAndPassword(EmailID , Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                              Toast.makeText(FacultyRegistrationActivity.this,"Registration Succesfull",Toast.LENGTH_SHORT).show();
                              startActivity(new Intent(FacultyRegistrationActivity.this,FacultyLoginActivity.class));
                          }else{
                              Toast.makeText(FacultyRegistrationActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                          }
                      }
                  });
                }
            }
        });
    }

    private void setupUIViews(){
        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        facultyid = (EditText)findViewById(R.id.Emailid);
        facultymail = (EditText)findViewById(R.id.facultymail);
        courseid = (EditText)findViewById(R.id.courseid);
        Register = (Button)findViewById(R.id.Register);

    }
    private Boolean validate() {
        Boolean result = false;

        String Name = name.getText().toString();
        String Password = password.getText().toString();
        String EmailID = facultymail.getText().toString();
        String FacultyID = facultyid.getText().toString();
        String CourseID = courseid.getText().toString();

        if (Name.isEmpty() || Password.isEmpty() || EmailID.isEmpty() || FacultyID.isEmpty() || CourseID.isEmpty()) {
            Toast.makeText(FacultyRegistrationActivity.this, "please enter all the details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }

        return result;
       }
 }

