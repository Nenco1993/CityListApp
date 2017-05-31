package com.example.neven.citylistapp.dagger.components;

import com.example.neven.citylistapp.activities.MainActivity;
import com.example.neven.citylistapp.dagger.modules.ListModule;
import com.example.neven.citylistapp.dagger.scopes.ActivityScope;
import dagger.Subcomponent;

/**
 * Created by Neven on 30.5.2017..
 */
@ActivityScope
@Subcomponent(modules = {ListModule.class})
public interface ListComponent {

    void inject(MainActivity activity);

}
