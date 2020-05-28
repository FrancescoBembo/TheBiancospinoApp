package com.example.thebiancospinoapp;

import android.app.FragmentManager;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentController;
import androidx.recyclerview.widget.GridLayoutManager;
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

        View rootView = inflater.inflate(R.layout.fragment_shop, container, false);
        initImageBitmaps();
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mTitles, mProd_prices, mThumbnailsUrl, this.getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
        // Inflate the layout for this fragment
        return rootView;



    }

    private void initImageBitmaps(){

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/Product1.png?alt=media&token=dbd69ab0-5daa-4dc8-8e1d-1e98ee1a960f");
        mTitles.add("Pasta kamut");
        mProd_prices.add("$3.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 2");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 3");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 4");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 5");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 6");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 7");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 8");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 9");
        mProd_prices.add("$5.99");

        mThumbnailsUrl.add("");
        mTitles.add("Product 10");
        mProd_prices.add("$5.99");

        // initRecyclerView();

    }





}
