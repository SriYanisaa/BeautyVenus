package com.example.beautyvenus;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private SharedPreferences sharedPreferences;
    Context context;
    private SharedPreferences.Editor editor;

    public SharedPrefManager (Context context){this.context = context;}

    public void logout(){
        sharedPreferences=context.getSharedPreferences("logout", Context.MODE_PRIVATE);
        editor  = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
