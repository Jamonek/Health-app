package com.jamonek.healthapp;

import java.util.ArrayList;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.jamonek.task2.R;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MapActivity extends FragmentActivity {
    /** (non-Javadoc)
     * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
	
	private ArrayList<String> myList = new ArrayList<String>();
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
        
        // Create the menu
        myList.add("Menu");
        myList.add("Tasks");
        myList.add("Points of Interest");
        myList.add("Account Management");
        
        // Get the users current location
        location = map.getMyLocation();
        
        // Print out the location coordinates
        System.out.println(map.getMyLocation());
        
        
        // Insert the items into the menu
        ListView lv = (ListView)findViewById(R.id.items);
        ArrayAdapter<String> myarrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        lv.setAdapter(myarrayAdapter);
        lv.setTextFilterEnabled(true);
    }
}
