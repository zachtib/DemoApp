package com.zachtib.demoapp;

import android.app.Application;

import com.zachtib.demoapp.injection.AppComponent;
import com.zachtib.demoapp.injection.AppModule;
import com.zachtib.demoapp.injection.DaggerAppComponent;
import com.zachtib.demoapp.injection.NetModule;

public class DemoApp extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://192.168.1.200:8000"))
                .build();
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
