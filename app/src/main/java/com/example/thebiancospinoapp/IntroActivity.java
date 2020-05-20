package com.example.thebiancospinoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroviewPagerAdapter introviewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Shop Anywhere", "dadfs adfadf fd,\nad fa dfdad fdfsdfadf", R.drawable.onb1));
        mList.add(new ScreenItem("New recipes", "dadfs ad fhh hhadf fd,\nad fa dfdj ad fdfsdfadf", R.drawable.onb2));
        mList.add(new ScreenItem("Get points", "dadfs  fd,\nad fa dfdad g fdfsdfadf", R.drawable.onb3));

        screenPager =findViewById(R.id.screen_viewpager);
        introviewPagerAdapter = new IntroviewPagerAdapter(this,mList);

        screenPager.setAdapter(introviewPagerAdapter);

    }
}
