package com.example.goaapp;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.goaapp.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements TouristPlaces.OnFragmentInteractionListener
        ,Hotels.OnFragmentInteractionListener,Restaurants.OnFragmentInteractionListener
        ,Markets.OnFragmentInteractionListener,Transportation.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        final ViewPager viewPager = findViewById(R.id.view_pager);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        tabs.addTab(tabs.newTab().setText("Tourist Places"));
        tabs.addTab(tabs.newTab().setText("Hotels"));
        tabs.addTab(tabs.newTab().setText("Restaurants"));
        tabs.addTab(tabs.newTab().setText("Markets"));
        tabs.addTab(tabs.newTab().setText("Transportation"));

        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        //tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabs.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}