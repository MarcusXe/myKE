package com.example.xeby.myke;

import android.app.Application;

import com.example.xeby.myke.Utils.SharePreferenceUntil;

public class AppService extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharePreferenceUntil.init(this);
    }
}