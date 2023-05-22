package com.example.task9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.task9.Adapter.AdvertListAdapter;
import com.example.task9.Adapter.AdvertViewModel;
import com.example.task9.database.Advert;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private AdvertViewModel advertViewModel;
    double latlong;
    AdvertListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        advertViewModel = new ViewModelProvider(MapsActivity.this).get(AdvertViewModel.class);

        listAdapter = new AdvertListAdapter(new AdvertListAdapter.AdvertDiff(),
                this, advertViewModel);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng melbourne = new LatLng(-37.813629, 144.963058);

        LatLng melbourne2 = new LatLng(-37.846887, 145.114419);

        LatLng melbourne3 = new LatLng(-37.848419, 144.714951);

            googleMap.addMarker(new MarkerOptions()
                    .position(melbourne)
                    .title("Marker"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(melbourne));

        googleMap.addMarker(new MarkerOptions()
                .position(melbourne2)
                .title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(melbourne));

        googleMap.addMarker(new MarkerOptions()
                .position(melbourne3)
                .title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(melbourne));

    }
}