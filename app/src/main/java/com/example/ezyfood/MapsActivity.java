package com.example.ezyfood;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ezyfood.data.RestaurantData;
import com.example.ezyfood.models.Restaurant;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static long money;
    public static Restaurant temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        money = 0;
        RestaurantData.setRestaurant();
        ArrayList<Restaurant> resData = RestaurantData.restaurants;
        for (int idx = 0; idx < resData.size(); idx++) {
            LatLng res = new LatLng(resData.get(idx).getLatitude(), resData.get(idx).getLongitude());
            googleMap.addMarker(new MarkerOptions().position(res).title(resData.get(idx).getName()));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(res));
            final Restaurant restaurant= resData.get(idx);
            googleMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) marker -> {
                Intent i = new Intent(MapsActivity.this, MainActivity.class);
                temp = restaurant;
                startActivity(i);
                return true;
            });
        }
    }
}