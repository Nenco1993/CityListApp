package com.example.neven.citylistapp.presenters;

import com.example.neven.citylistapp.models.City;
import com.example.neven.citylistapp.models.MainData;
import com.example.neven.citylistapp.network.RestAPI;
import com.example.neven.citylistapp.views.ListCityView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Neven on 30.5.2017..
 */
public class ListPresenterImpl implements ListPresenter {

    private final Retrofit retrofit;
    private final ListCityView view;

    @Inject
    public ListPresenterImpl(Retrofit retrofit, ListCityView view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void downloadData() {

        RestAPI api = retrofit.create(RestAPI.class);
        Call<MainData> call = api.getCity();
        call.enqueue(new Callback<MainData>() {
            @Override
            public void onResponse(Call<MainData> call, Response<MainData> response) {

                List<City> listCity = response.body().getCity();
                view.showData(listCity);


            }

            @Override
            public void onFailure(Call<MainData> call, Throwable t) {

                t.printStackTrace();


            }
        });


    }
}
