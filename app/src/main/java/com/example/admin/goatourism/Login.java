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

public class Login extends AppCompatActivity {
    EditText email,password;
    Button loginbtn;
    TextView register;
    ProgressBar progressBar;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=(EditText)findViewById(R.id.loginemail);
        password=(EditText)findViewById(R.id.loginpassword);
        loginbtn=(Button) findViewById(R.id.buttonLogin);
        register=(TextView)findViewById(R.id.register);
        progressBar= (ProgressBar) findViewById(R.id.progressBar3);
        fauth=FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String emailverify=email.getText().toString().trim();
                String pwdverify= password.getText().toString().trim();

                if(TextUtils.isEmpty(emailverify))
                {
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pwdverify))
                {
                    password.setError("Password is required");
                    return;
                }
                progressBar.setVisibility(view.VISIBLE);

                fauth.signInWithEmailAndPassword(emailverify,pwdverify).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this,"Logged In Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else {
                            Toast.makeText(Login.this,"Error!!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(view.INVISIBLE);


                        }
                    }
                });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });



    }

}
