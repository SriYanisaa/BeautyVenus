package com.example.beautyvenus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailItem extends AppCompatActivity {

    private Button btnbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        getSupportActionBar().hide();

        btnbook = findViewById(R.id.booknow);

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent book = new Intent(DetailItem.this, Booking.class);
                startActivity(book);
            }
        });
//        produk1 = (CardView) findViewById(R.id.c1);


//        produk1.setOnClickListener(this);
    }

//    public void onClick(View view){
//        Intent form;
//
//        switch (view.getId()){
//            case R.id.c1:
//                form = new Intent(this, Booking.class);
//                startActivity(form);
//                break;
//            case R.id.c2:
//                form = new Intent(this, Booking.class);
//                startActivity(form);
//                break;
//        }
//
//    }
}