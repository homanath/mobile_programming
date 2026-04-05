package com.example.networkmapsapp;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // EXACT COORDINATES FOR ITAHARI NAMUNA COLLEGE
        // Latitude: 26.6576, Longitude: 87.2721
        LatLng namunaCollege = new LatLng(26.651119, 87.275224);
        // Add a marker exactly at the college
        googleMap.addMarker(new MarkerOptions()
                .position(namunaCollege)
                .title("Itahari Namuna College")
                .snippet("BCA Lab 9 - Mobile Programming"));

        // Set zoom level to 17.0f (Closer view to see the college buildings)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(namunaCollege, 17.0f));

        // Enable UI tools
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
    }
}