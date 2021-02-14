package com.sda.syeddaniyalali.procom_2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //Declaring-------------------------------------------------------------------------
    TextView tvAlreadyAccount;
    EditText txtUserName, txtUserEmail, txtUserPass;
    Button btnRegister;
    private FirebaseAuth mAuth;

   /* @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initalizing-------------------------------------------------------------------------
        tvAlreadyAccount =findViewById(R.id.tv_already_acc);
        txtUserName = findViewById(R.id.txt_user_name_reg);
        txtUserEmail = findViewById(R.id.txt_User_email_reg);
        txtUserPass = findViewById(R.id.txt_user_pass_reg);
        btnRegister =findViewById(R.id.btn_user_reg);
        FirebaseApp.initializeApp(this);


        try
        {
            mAuth = FirebaseAuth.getInstance();
            
        }
        catch (Exception e)
        {
            txtUserPass.setText(e.getMessage());
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduser();
            }
        });

        tvAlreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivityUser.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void adduser()
    {
        String Email=txtUserEmail.getText().toString().trim();
        String Pass=txtUserPass.getText().toString().trim();

        if(!TextUtils.isEmpty(Email)&& !TextUtils.isEmpty(Pass) && Pass.length()==6)
        {
            mAuth.createUserWithEmailAndPassword(Email, Pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                                Toast.makeText(MainActivity.this, "Register Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(MainActivity.this,LoginActivityUser.class);
                                startActivity(intent);
                                finish();


                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Already Registered",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }

                            // ...
                        }
                    });
        }
    }
    private void updateUI(FirebaseUser user) {

        if (user != null) {
            //Toast.makeText(this, ""+user, Toast.LENGTH_SHORT).show();

        } else {
            //Toast.makeText(this, "UpdateUi error", Toast.LENGTH_SHORT).show();
        }
    }


}
