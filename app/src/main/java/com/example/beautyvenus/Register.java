package com.example.beautyvenus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private TextView txtlogin;
    private EditText EditNama, EditAlamat, EditEmail, EditPass, Editkonfigpass;
    private Button btnregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        EditNama = findViewById(R.id.editnama);
        EditAlamat = findViewById(R.id.editalamat);
        EditEmail = findViewById(R.id.editmail);
        EditPass = findViewById(R.id.password);
        Editkonfigpass = findViewById(R.id.konfigpass);
        txtlogin = findViewById(R.id.txtLogin);
        btnregister = findViewById(R.id.btnregis);


        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Register.this, Login.class);
                startActivity(k);
            }
        });

        btnregister.setOnClickListener(view -> {
            if (EditNama.getText().length()>0 && EditAlamat.getText().length()>0 && EditEmail.getText().length()>0 && EditPass.getText().length()>0 &&
                    Editkonfigpass.getText().length()>0){

                if(EditPass.getText().toString().equals(Editkonfigpass.getText().toString())){
                    register(EditNama.getText().toString(), EditAlamat.getText().toString(), EditEmail.getText().toString(), EditPass.getText().toString());
                }else{
                    AlertDialog.Builder builer = new AlertDialog.Builder(Register.this);
                    builer.setMessage("Password Anda Tidak Sesuai").setNegativeButton("Retry", null).create().show();
                }
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                builder.setMessage("Silahkan Lengkapi Semua Data Anda").setNegativeButton("Retry", null).create().show();
            }
        });


    }

    public void register (String nama, String alamat, String email, String pass){
        Toast.makeText(getApplicationContext(), "REGISTRASI BERHASIL", Toast.LENGTH_LONG).show();
        Intent log = new Intent(Register.this, Login.class);
        log.putExtra("username", EditNama.getText().toString());
        log.putExtra("password", EditPass.getText().toString());
        startActivity(log);
    }

}