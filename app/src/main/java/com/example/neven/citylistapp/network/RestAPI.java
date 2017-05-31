package com.example.neven.citylistapp.network;

import com.example.neven.citylistapp.models.MainData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Neven on 30.5.2017..
 */
public interface RestAPI {

    @GET("city_list_location.json")
    Call<MainData>getCity();


}
