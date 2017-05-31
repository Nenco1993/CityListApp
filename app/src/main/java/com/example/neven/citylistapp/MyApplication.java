package com.example.neven.citylistapp;

import android.app.Application;
import com.example.neven.citylistapp.dagger.components.AppComponent;
import com.example.neven.citylistapp.dagger.components.DaggerAppComponent;

/**
 * Created by Neven on 30.5.2017..
 */
public class MyApplication extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();


    }
}
