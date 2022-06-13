package com.example.beautyvenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.beautyvenus.fragment.StatusPemesanan;

public class ReviewPemesanan extends AppCompatActivity {

    private EditText namaPem, namaBarang, jmlh, harga, bayar;
    private Button btnbyar;
    private Button btnproses;
    private TextView totalharga;
    private TextView kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_pemesanan);

        getSupportActionBar().hide();

        namaPem = (EditText) findViewById(R.id.namapelanggan);
        namaBarang = (EditText) findViewById(R.id.namabarang);
        jmlh = (EditText) findViewById(R.id.jumlahbeli);
        harga = (EditText) findViewById(R.id.harga);
        bayar = (EditText) findViewById(R.id.uangbayar);
        btnproses =  (Button) findViewById(R.id.tombol1);
        btnbyar = (Button) findViewById(R.id.tombol3);
        totalharga = (TextView) findViewById(R.id.totalbelanja);
        kembali = (TextView) findViewById(R.id.uangkembali);

        namaPem.setText(getIntent().getStringExtra("username"));
        namaBarang.setText(getIntent().getStringExtra("Nama"));

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = namaPem.getText().toString().trim();
                String namabarang = namaBarang.getText().toString().trim();
                String jumlahbeli = jmlh.getText().toString().trim();
                String hargatotal = harga.getText().toString().trim();
                String uangbayar = bayar.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(hargatotal);
                double total = (jb * h);
                double ub = Double.parseDouble(uangbayar);
                totalharga.setText("Total Belanja : " + total);
                double uangkembalian = (ub - total);

                if (ub < total){
                    kembali.setText("Uang Kembali : Rp 0" );
                }else{
                    kembali.setText("Uang Kembali : " + uangkembalian);
                }
            }
        });

        btnbyar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StatusPemesanan status = new StatusPemesanan();
                status.show(getSupportFragmentManager(), "My Fragment");
            }
        });

    }
}