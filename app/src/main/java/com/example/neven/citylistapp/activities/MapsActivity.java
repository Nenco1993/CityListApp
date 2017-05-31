package com.example.neven.citylistapp.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.neven.citylistapp.R;
import com.example.neven.citylistapp.models.City;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        city = (City) getIntent().getSerializableExtra("city");

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        double latitude = Double.parseDouble(city.getLatitude());
        double longitude = Double.parseDouble(city.getLongitude());
        LatLng sydney = new LatLng(latitude, longitude);
        googleMap.addMarker(new MarkerOptions().position(sydney).title(city.getName()));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}
