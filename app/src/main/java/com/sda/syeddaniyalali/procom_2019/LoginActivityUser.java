package com.sda.syeddaniyalali.procom_2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import org.w3c.dom.Text;

public class LoginActivityUser extends AppCompatActivity {

    //Declaring-------------------------------------------------------------------------
    EditText txtUserEmail, txtUserPass;
    Button btnLogin;
    private FirebaseAuth mAuth;
    private TextView tv_create_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        //Initalizing-------------------------------------------------------------------------
        txtUserEmail = findViewById(R.id.txt_User_email_login);
        txtUserPass =  findViewById(R.id.txt_user_pass_login);
        btnLogin = findViewById(R.id.btn_user_login);
        tv_create_acc=findViewById(R.id.tv_create_acc);

        try
        {
            mAuth = FirebaseAuth.getInstance();

        }
        catch (Exception e)
        {
            txtUserPass.setText(e.getMessage());
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });


        tv_create_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivityUser.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }

    private void checkUser()
    {
        String Email=txtUserEmail.getText().toString().trim();
        String Pass=txtUserPass.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(Email, Pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent=new Intent(LoginActivityUser.this,SocialTab.class);
                            startActivity(intent);
                            finish();

                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivityUser.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser user) {

        if (user != null) {
           // Toast.makeText(this, ""+user, Toast.LENGTH_SHORT).show();

        } else {
            //Toast.makeText(this, "UpdateUi error", Toast.LENGTH_SHORT).show();
        }
    }


}
