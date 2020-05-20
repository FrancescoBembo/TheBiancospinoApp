package com.example.thebiancospinoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private Button BtnSkip;

    private ViewPager screenPager;
    IntroviewPagerAdapter introviewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Shop anytime, anywhere!", "Shop at any time and decide whether to pick up your\norder or get it delivered at your doorstep.", R.drawable.onb1));
        mList.add(new ScreenItem("Discover new recipes!", "Discover new weekly recipes, and buy \nall the ingredients with one tap.", R.drawable.onb2));
        mList.add(new ScreenItem("Earn points and rewards!", "Earn points with every purchase on the app on in\nstore and unlock rewards and discounts.", R.drawable.onb3));

        screenPager =findViewById(R.id.screen_viewpager);
        introviewPagerAdapter = new IntroviewPagerAdapter(this,mList);

        screenPager.setAdapter(introviewPagerAdapter);



        BtnSkip = findViewById(R.id.btn_skip);
        BtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToMainActivity();

            }
        });



    }

    private void moveToMainActivity(){

        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
