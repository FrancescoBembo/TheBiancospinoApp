package com.example.thebiancospinoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private Button BtnSkip;

    private ViewPager screenPager;
    IntroviewPagerAdapter introviewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStatred;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        name = getIntent().getStringExtra("name");
        btnNext = findViewById(R.id.btn_next);
        BtnSkip = findViewById(R.id.btn_skip);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnGetStatred = findViewById(R.id.btn_get_started);

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Shop anytime, anywhere!", "Shop at any time and decide whether to pick up your\norder or get it delivered at your doorstep.", R.drawable.onb1));
        mList.add(new ScreenItem("Discover new recipes!", "Discover new weekly recipes, and buy \nall the ingredients with one tap.", R.drawable.onb2));
        mList.add(new ScreenItem("Earn points and rewards!", "Earn points with every purchase on the app on in\nstore and unlock rewards and discounts.", R.drawable.onb3));

        screenPager =findViewById(R.id.screen_viewpager);
        introviewPagerAdapter = new IntroviewPagerAdapter(this,mList);

        screenPager.setAdapter(introviewPagerAdapter);


        tabIndicator.setupWithViewPager(screenPager);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = screenPager.getCurrentItem();
                if (position < mList.size()) {

                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size() - 1) {
                    loadLastScreen();
                }

            }
        });






        BtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToMainActivity();

            }
        });


        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size() -1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        btnGetStatred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToMainActivity();

            }
        });





    }

    private void loadLastScreen() {

        btnNext.setVisibility(View.INVISIBLE);
        BtnSkip.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btnGetStatred.setVisibility(View.VISIBLE);



    }



    private void moveToMainActivity(){

        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);

    }
}
