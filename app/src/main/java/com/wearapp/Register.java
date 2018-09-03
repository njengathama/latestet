package com.wearapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends AppCompatActivity {

    private AutoCompleteTextView etname,etEmail, etPassword, retype;
    private Button Reg;
    TextView tv_login;
    private CheckBox chkIos;

    private ProgressDialog progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        getWindow().setBackgroundDrawableResource(R.drawable.back);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        progressBar=new ProgressDialog(this);
        etname=(AutoCompleteTextView)findViewById(R.id.username);
        etEmail=(AutoCompleteTextView)findViewById(R.id.userEmail);
        etPassword=(AutoCompleteTextView)findViewById(R.id.userPassword);
        retype=(AutoCompleteTextView)findViewById(R.id.userRetypePassword);
        tv_login = (TextView)findViewById(R.id.tv_login);
        Reg=(Button)findViewById(R.id.btReg);
        chkIos = (CheckBox) findViewById(R.id.chkIos);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();

            }
        });


    }

    private void registerUser() {
        String name=etname.getText().toString().trim();
        final String mail=etEmail.getText().toString().trim();
        String pass=etPassword.getText().toString().trim();
        String retypepass=retype.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        /*if(!TextUtils.isEmpty(mail) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(retypepass)&&
            (chkIos.isChecked()))*/
        {
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(mail)) {
                Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                return;
            }


            if (!mail.matches(emailPattern)) {
                Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();

                return;
            }

            if (TextUtils.isEmpty(pass)) {
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (pass.length() < 6) {
                etPassword.setError("Password too Short!");
                //Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(pass)) {
                retype.setError("error, Doesnt Match!");
                //Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!chkIos.isChecked()) {
                Toast.makeText(getApplicationContext(), "You should agree to terms and conditions to continue!", Toast.LENGTH_SHORT).show();
            }


            else {
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                progressBar.setMessage("Signing in ...");
                progressBar.show();

            }


                        }
                    }



    @Override
    protected void onResume() {
        super.onResume();

    }
}
