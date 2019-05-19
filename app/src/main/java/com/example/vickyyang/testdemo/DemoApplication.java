package com.example.vickyyang.testdemo;

import android.app.Application;
import com.example.vickyyang.testdemo.utils.SPUtils;

public class DemoApplication extends Application {

    private static Application mApp;

    public static Application getInstance(){
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mApp = this;

        SPUtils.putLong("BOOT_TIME",System.currentTimeMillis());
        int count = SPUtils.getInt("BOOT_COUNT",0)+1;
        SPUtils.putInt("BOOT_COUNT",count);

    }
}
