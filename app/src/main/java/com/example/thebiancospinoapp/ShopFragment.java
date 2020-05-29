package com.example.thebiancospinoapp;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment{

    public ShopFragment() {
        // Required empty public constructor
    }


    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mProd_prices = new ArrayList<>();
    private ArrayList<String> mThumbnailsUrl = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        initImageBitmaps();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mTitles, mProd_prices, mThumbnailsUrl, this.getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));


        // Inflate the layout for this fragment
        return view;



    }

    private void initImageBitmaps(){

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/1.png?alt=media&token=ac42265f-478e-4c4e-9565-d0d919f4cb65");
        mTitles.add("Pasta kamut");
        mProd_prices.add("$3.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/2.png?alt=media&token=8de2a304-60ab-4426-b6ea-73461373dc53");
        mTitles.add("Tagliatelle farro");
        mProd_prices.add("$2.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/3.png?alt=media&token=f59135d8-fdf1-4622-9cae-647d81e88921");
        mTitles.add("Cracker farro");
        mProd_prices.add("$3.50");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/4.png?alt=media&token=d81bd64f-0384-4084-b65e-992a30a16253");
        mTitles.add("SoftCrock rosemary");
        mProd_prices.add("$1.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/5.png?alt=media&token=53a6c463-9056-4a32-bdd5-6fa36b790758");
        mTitles.add("Mais balls");
        mProd_prices.add("$1.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/6.png?alt=media&token=ce59cf92-d597-4fc1-a321-ca7ca93d11a0");
        mTitles.add("Cooking salt");
        mProd_prices.add("$2.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/7.png?alt=media&token=af574fb8-415f-480e-becd-e9f76cadd59f");
        mTitles.add("Goji berries");
        mProd_prices.add("$5.50");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/8.png?alt=media&token=b09a9eae-2c0e-4da4-8cf1-fcb42138ee05");
        mTitles.add("Choco spread");
        mProd_prices.add("$4.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/9.png?alt=media&token=56b39b8f-71ba-401c-adbb-b89b5e098d6c");
        mTitles.add("Soya choc dessert");
        mProd_prices.add("$3.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/10.png?alt=media&token=3f73706c-7a9e-4629-9914-2ed957ed11e6");
        mTitles.add("Soya van dessert");
        mProd_prices.add("$3.99");



    }





}
