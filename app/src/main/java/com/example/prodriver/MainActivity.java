package com.example.prodriver;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*Initialize variables to be used*/
    ViewPager viewPager;
    SliderAdapter sliderAdapter;

    Button mbuttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Display in FullScreen*/
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        /*Initialization to take place*/
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);


        mbuttonNext = (Button) findViewById(R.id.btnNext);

    }
}
