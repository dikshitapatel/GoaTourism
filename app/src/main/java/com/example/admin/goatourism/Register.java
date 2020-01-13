package com.example.admin.goatourism;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText name,email,password,phone;
    TextView login;
    Button signupbtn;
    FirebaseAuth fauth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=(EditText)findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        phone=(EditText)findViewById(R.id.phone);
        signupbtn=(Button) findViewById(R.id.buttonSignup);
        login=(TextView)findViewById(R.id.textView2);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        fauth=FirebaseAuth.getInstance();

        if (fauth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String nameverify=name.getText().toString().trim();
                String emailverify= email.getText().toString().trim();
                String passwordverify=password.getText().toString().trim();
                String phoneverify=phone.getText().toString().trim();

                if(TextUtils.isEmpty(nameverify))
                {
                    name.setError("Name is required");
                    return;
                }
                if(TextUtils.isEmpty(emailverify))
                {
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(passwordverify))
                {
                    password.setError("Password is required");
                    return;
                }
                if(TextUtils.isEmpty(phoneverify))
                {
                    phone.setError("Phone No. is required");
                    return;
                }
                if(passwordverify.length()<6)
                {
                    password.setError("Minimum 8 characters required!");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                fauth.createUserWithEmailAndPassword(emailverify,passwordverify).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else {
                            Toast.makeText(Register.this,"Error!!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(view.INVISIBLE);

                        }

                    }
                }
                );
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

    }
}
