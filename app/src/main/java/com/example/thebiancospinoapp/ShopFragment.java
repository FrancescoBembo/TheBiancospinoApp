package com.example.thebiancospinoapp;

import android.app.FragmentManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.dynamic.FragmentWrapper;

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


        initImageBitmaps();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false);



    }

    private void initImageBitmaps(){

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 1");
        mProd_prices.add("$5.99");

        initRecyclerView();

    }


    private void initRecyclerView(){

        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mTitles, mProd_prices, mThumbnailsUrl );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));



    }

}
