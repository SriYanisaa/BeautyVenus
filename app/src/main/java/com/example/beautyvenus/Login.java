package com.example.beautyvenus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beautyvenus.fragment.AccountFragment;
import com.example.beautyvenus.fragment.HomeFragment;

public class Login extends AppCompatActivity {

    private TextView txtregis;
    private EditText editemail, editpass;
    private Button login;
    private CheckBox showpass;
    String nama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        editemail = findViewById(R.id.editEmail);
        editpass = findViewById(R.id.editPass);
        txtregis = findViewById(R.id.txtRegister);
        login = findViewById(R.id.btnlogin);
        showpass = findViewById(R.id.showpass);

        editemail.setText(getIntent().getStringExtra("username"));
        editpass.setText(getIntent().getStringExtra("password"));

        txtregis.setOnClickListener(view -> {
            Intent j = new Intent(Login.this, Register.class);
            startActivity(j);
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = editemail.getText().toString();
                if(editemail.getText().length()>0  && editpass.getText().length()>0){
                    login(editemail.getText().toString(), editpass.getText().toString());
                } else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Silahkan Masukkan Email dan Password Anda!").setNegativeButton("Retry", null).create().show();
                }
            }
        });

        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked){
                    editpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    editpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    private void login(String email, String password){
        Toast.makeText(getApplicationContext(), "Halo, "+nama, Toast.LENGTH_LONG).show();
        Intent log = new Intent(Login.this, Dashboard.class);
        log.putExtra("Nama", editemail.getText().toString());
        log.putExtra("Formnama", editemail.getText().toString());
        startActivity(log);
    }
}