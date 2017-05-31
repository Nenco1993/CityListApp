
package com.example.neven.citylistapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainData {

    @SerializedName("app")
    @Expose
    private String app;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("city")
    @Expose
    private List<City> city = null;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

}
