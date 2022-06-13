package com.example.beautyvenus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.beautyvenus.fragment.StatusPemesanan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Booking extends AppCompatActivity {

    private Button btnpesan;
    private EditText editDate;
    private EditText editTime;
    private EditText editNama;
    private EditText editLayanan;
    int jam, menit;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        getSupportActionBar().hide();

        editNama = findViewById(R.id.formnama);
        editDate = findViewById(R.id.tanggal);
        editLayanan = findViewById(R.id.layanan);
        editTime = findViewById(R.id.jam);
        btnpesan = findViewById(R.id.pesan);

        editNama.setText(getIntent().getStringExtra("Formnama"));

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Booking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        editDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        Booking.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                                jam = hourOfDay;
                                menit = minute;

                                String time = jam + ":" + menit;
                                SimpleDateFormat f24jam = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24jam.parse(time);
                                    SimpleDateFormat f12jam = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    editTime.setText(f12jam.format(date));
                                }catch (ParseException e){
                                    e.printStackTrace();
                                }
                            }
                        },12, 0, false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(jam,menit);
                timePickerDialog.show();
            }
        });

        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent review = new Intent(Booking.this, ReviewPemesanan.class);
                review.putExtra("username", editNama.getText().toString());
                review.putExtra("Nama", editLayanan.getText().toString());
                startActivity(review);
//                StatusPemesanan status = new StatusPemesanan();
//                status.show(getSupportFragmentManager(), "My Fragment");
            }
        });

    }
}