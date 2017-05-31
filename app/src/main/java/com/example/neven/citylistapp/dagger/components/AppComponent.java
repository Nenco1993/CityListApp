package com.example.neven.citylistapp.dagger.components;

import com.example.neven.citylistapp.activities.BaseActivity;
import com.example.neven.citylistapp.dagger.modules.AppModule;
import com.example.neven.citylistapp.dagger.modules.ListModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by Neven on 30.5.2017..
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(BaseActivity activity);

    ListComponent newListSubComponent(ListModule module);


}
