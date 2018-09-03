package com.wearapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wearapp.PrefManager;

public class Login extends AppCompatActivity {

    private Button btLog;
    private PrefManager prefManager;
    private TextView regtxt,tv_reset_password;

    private AutoCompleteTextView etEmail, etPassword;
    private ProgressDialog progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        prefManager= new PrefManager(this);
        if (prefManager.isFirstTimeLaunch()) {
            prefManager.setFirstTimeLaunch(false);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);







        getWindow().setBackgroundDrawableResource(R.drawable.back);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        progressBar=new ProgressDialog(this);
        etEmail=(AutoCompleteTextView)findViewById(R.id.userEmailLog);
        etPassword=(AutoCompleteTextView)findViewById(R.id.userPasswordLog);
        tv_reset_password = (TextView)findViewById(R.id.tv_reset_password);
        btLog=(Button) findViewById(R.id.btLog);
        regtxt=(TextView) findViewById(R.id.regtxt);


        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });




        regtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register.class));
                finish();
            }
        });
        tv_reset_password .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ResetPasswordActivity.class));
            }
        });

    }






    }

