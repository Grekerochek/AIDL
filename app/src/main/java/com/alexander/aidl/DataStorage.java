package com.alexander.aidl;

import android.content.Context;
import android.content.SharedPreferences;

public class DataStorage {

    private static final String PREF_NAME = "PREF";
    private static final String DATA_KEY = "key";
    private Context context;

    public DataStorage(Context context){
        this.context = context;
    }

    public String getStorageData(){
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getString(DATA_KEY, null);
    }

    public void saveStorageData(String data){
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(DATA_KEY, data);
        editor.apply();
    }
}
