package com.xtron.dealaroundme.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.adpter.Adapter_rv_all_deals;

public class Home extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMapClickListener {


    private GoogleMap mMap;
    Button data, distance;
    ImageButton deal,flash_deal,my_filters;
    SupportMapFragment mMapFragment;
    LinearLayout layout;
    private FrameLayout mFragmentHolder;
    RecyclerView r;
    int i=0;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        mFragmentHolder = (FrameLayout) findViewById(R.id.fragmentHolder);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*mMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);*/

        mMapFragment = new SupportMapFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentHolder,mMapFragment,"map").commit();
        mMapFragment.getMapAsync(this);


        data = (Button) findViewById(R.id.data);
        data.setOnClickListener(this);
        distance = (Button) findViewById(R.id.distance);
        distance.setOnClickListener(this);

        deal = (ImageButton) findViewById(R.id.deal);
        deal.setOnClickListener(this);
        flash_deal = (ImageButton) findViewById(R.id.flashdeal);
        flash_deal.setOnClickListener(this);
        my_filters = (ImageButton) findViewById(R.id.my_filters);
        my_filters.setOnClickListener(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.linear_header);
        if (toolbar == null) {
            Log.e("toolbar", "is null");
            return;
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Deal Around Me");
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_settings);


        Adapter_rv_all_deals adapter_rv_all_deals = new Adapter_rv_all_deals(this);
        r = (RecyclerView) findViewById(R.id.alldeals_rv);
        r.setOnClickListener(this);
        r.setAdapter(adapter_rv_all_deals);
        r.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.header, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.search: {
                break;
            }
            case android.R.id.home: {
                startActivity(new Intent(this, Drawer.class));
                break;
            }
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        layout=(LinearLayout)findViewById(R.id.layout);
        /*if (mMapFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .remove(mMapFragment).commit();
            mFragmentHolder.setVisibility(View.GONE);
        }
        else
            Log.e("map", "Map is null");*/
        switch (v.getId()) {
            case R.id.data:
                r.setVisibility(View.VISIBLE);
                break;
            case R.id.distance:
                r.setVisibility(View.VISIBLE);
                break;

            case R.id.deal:
                if (mMapFragment != null) {
                    if(mFragmentHolder.getVisibility()==View.GONE&&i==1) {
                        startActivity(new Intent(this, Home.class));
                       /* mFragmentHolder.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction()
                                .add((R.id.fragmentHolder), mMapFragment, "map").commit();*/
                    }
                    else{
                        getSupportFragmentManager().beginTransaction()
                                .remove(mMapFragment).commit();
                    mFragmentHolder.setVisibility(View.GONE);
                        layout.setVisibility(View.GONE);
                    r.setVisibility(View.VISIBLE);
                    i=1;}

                }
                break;
            case R.id.flashdeal:
                if (mMapFragment != null) {
                    if(mFragmentHolder.getVisibility()==View.GONE&&i==2) {
                        startActivity(new Intent(this, Home.class));
                    }
                    else{
                        getSupportFragmentManager().beginTransaction()
                                .remove(mMapFragment).commit();
                        mFragmentHolder.setVisibility(View.GONE);
                        layout.setVisibility(View.GONE);
                        r.setVisibility(View.VISIBLE);
                    i=2;}

                }
                break;
            case R.id.my_filters:
                if (mMapFragment != null) {
                    if(mFragmentHolder.getVisibility()==View.GONE&&i==3) {
                        startActivity(new Intent(this, Home.class));
                        /*mFragmentHolder.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction()
                                .add((R.id.fragmentHolder), mMapFragment, "map").commit();*/
                    }
                    else{
                        getSupportFragmentManager().beginTransaction()
                                .remove(mMapFragment).commit();
                        mFragmentHolder.setVisibility(View.GONE);
                        layout.setVisibility(View.GONE);
                        r.setVisibility(View.VISIBLE);
                    i=3;}

                }
                break;
        }

    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (r != null) {
            r.setVisibility(r.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        layout=(LinearLayout)findViewById(R.id.layout);
        if(r.getVisibility()==View.GONE||layout.getVisibility()==View.GONE)
        startActivity(new Intent(this,Home.class));
        else
            this.finishAffinity();
    }
}
