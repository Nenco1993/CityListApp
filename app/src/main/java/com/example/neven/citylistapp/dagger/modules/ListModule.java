package com.example.neven.citylistapp.dagger.modules;

import android.content.Context;
import com.example.neven.citylistapp.dagger.scopes.ActivityScope;
import com.example.neven.citylistapp.presenters.ListPresenter;
import com.example.neven.citylistapp.presenters.ListPresenterImpl;
import com.example.neven.citylistapp.views.ListCityView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Neven on 30.5.2017..
 */
@Module
public class ListModule {

    private final Context context;
    private final ListCityView view;


    public ListModule(Context context, ListCityView view) {
        this.context = context;
        this.view = view;

    }

    @Provides
    @ActivityScope
    ListPresenter provideListPresenter(ListPresenterImpl presenter) {

        return presenter;
    }

    @Provides
    @ActivityScope
    Context provideContext() {

        return context;


    }

    @Provides
    @ActivityScope
    ListCityView provideView() {

        return view;


    }




}
