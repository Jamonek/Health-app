package com.jamonek.healthapp;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MapActivity extends FragmentActivity {

	private GoogleMap map;
	private Location location;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        
        // Getting GoogleMap object from the fragment
        map = fm.getMap();
        
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        
        // Enabling MyLocation Layer of Google Map
        map.setMyLocationEnabled(true);
        
        // Get the users current location
        location = map.getMyLocation();
        
        // Print out the location coordinates
        System.out.println(location);
        
    }
}
