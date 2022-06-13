package com.example.beautyvenus.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beautyvenus.DetailItem;
import com.example.beautyvenus.Login;
import com.example.beautyvenus.R;
import com.example.beautyvenus.SharedPrefManager;

import org.w3c.dom.Text;

public class AccountFragment extends Fragment {

    TextView txtakun;
    ImageView logout;
    SharedPrefManager sharedPrefManager;


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        txtakun = rootView.findViewById(R.id.nama);
        txtakun.setText(getActivity().getIntent().getStringExtra("Nama"));

        sharedPrefManager = new SharedPrefManager(getActivity().getApplicationContext());
        logout = rootView.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefManager.logout();
                Intent intent = new Intent(getActivity(), Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                //Toast.makeText(this, "You have been logout", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity(), Login.class);
//                startActivity(intent);
            }
        });

        return rootView;
    }
}