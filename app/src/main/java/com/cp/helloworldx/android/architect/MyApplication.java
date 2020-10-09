package com.cp.helloworldx.android.architect;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication instance;
    public static MyApplication getInstance() {
        if (instance == null) {
            synchronized (MyApplication.class) {
                if(null == instance) {
                    instance = new MyApplication();
                }
            }
        }
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
