package com.example.beautyvenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.beautyvenus.fragment.AccountFragment;
import com.example.beautyvenus.fragment.AppoinmentFragment;
import com.example.beautyvenus.fragment.ChatFragment;
import com.example.beautyvenus.fragment.FavoriteFragment;
import com.example.beautyvenus.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().hide();

        bottomNavigation = findViewById(R.id.navigasi);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedfragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        selectedfragment = new HomeFragment();
                        break;
                    case R.id.favorite:
                        selectedfragment = new FavoriteFragment();
                        break;
                    case R.id.chat:
                        selectedfragment = new ChatFragment();
                        break;
                    case R.id.appoinment:
                        selectedfragment = new AppoinmentFragment();
                        break;
                    case R.id.akun:
                        selectedfragment = new AccountFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedfragment).commit();

                return true;
            }
        });
    }
}