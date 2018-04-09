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

public class StudentRegistrationActivity extends AppCompatActivity {

     private EditText Name,Password,Batch,EnrollmentNumber,EmailID;
     private Button button;
     private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        setupUIVews();

        firebaseAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //upload data to database
                    String email = EmailID.getText().toString().trim();
                    String password = Password.getText().toString().trim();
                   firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {

                           if(task.isSuccessful()) {
                               Toast.makeText(StudentRegistrationActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(StudentRegistrationActivity.this, StudentLoginActivity.class));
                           }else{
                               Toast.makeText(StudentRegistrationActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
                }
            }
        });

    }
    private void setupUIVews(){
        Name= (EditText)findViewById(R.id.name);
        Password= (EditText)findViewById(R.id.password);
        Batch= (EditText)findViewById(R.id.batch);
        EnrollmentNumber= (EditText)findViewById(R.id.enrollmentno);
        EmailID = (EditText)findViewById(R.id.email);
        button =(Button)findViewById(R.id.button);
    }

    private Boolean validate(){
        Boolean result = false;

        String name=Name.getText().toString();
        String password=Password.getText().toString();
        String batch=Batch.getText().toString();
        String email=EmailID.getText().toString();
        String enrollmentno=EnrollmentNumber.getText().toString();

        if(name.isEmpty() && password.isEmpty() && email.isEmpty() && batch.isEmpty() && enrollmentno.isEmpty()){
            Toast.makeText(this, "please enter all the details",Toast.LENGTH_SHORT);
        }else{
            result = true;
        }
        return result;
    }
}
