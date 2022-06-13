package com.example.beautyvenus.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.beautyvenus.Dashboard;
import com.example.beautyvenus.R;

public class StatusPemesanan extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_status_pemesanan,container,false);

        Button btnhome = (Button) rootView.findViewById(R.id.backhome);
        TextView txtappoinment = (TextView) rootView.findViewById(R.id.textappoinment);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getActivity(), Dashboard.class);
                startActivity(home);
//                FragmentTransaction home = getFragmentManager().beginTransaction();
//                home.replace(R.id.dialog_status, new HomeFragment());
//                home.commit();
            }
        });

        txtappoinment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction appoinment = getFragmentManager().beginTransaction();
                appoinment.replace(R.id.dialog_status, new AppoinmentFragment());
                appoinment.commit();
            }
        });

        return rootView;
    }
}