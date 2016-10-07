package com.zachtib.demoapp;

import android.app.Application;

import com.zachtib.demoapp.injection.AppComponent;
import com.zachtib.demoapp.injection.AppModule;
import com.zachtib.demoapp.injection.DaggerAppComponent;

public class DemoApp extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
