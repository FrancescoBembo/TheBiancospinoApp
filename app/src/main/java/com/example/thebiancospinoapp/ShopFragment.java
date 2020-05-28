package com.example.thebiancospinoapp;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P1.png?alt=media&token=6e70d36f-2e06-4ffc-93ee-4a3fdfb39d3f");
        mTitles.add("Pasta kamut");
        mProd_prices.add("$3.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P2.png?alt=media&token=86745114-c445-4cdd-a980-df320302184e");
        mTitles.add("Tagliatelle farro");
        mProd_prices.add("$2.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P3.png?alt=media&token=962a1cc2-86df-410e-bcfe-c78a23aaed50");
        mTitles.add("Cracker farro");
        mProd_prices.add("$3.50");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P4.png?alt=media&token=a9f4caee-770b-4832-80de-1fd60d5c6c76");
        mTitles.add("SoftCrock rosemary");
        mProd_prices.add("$1.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P5.png?alt=media&token=77f28bb3-3184-4209-b3b3-16c5182fd7cb");
        mTitles.add("Mais balls");
        mProd_prices.add("$1.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P6.png?alt=media&token=29d20ba1-8d68-43eb-8350-2104111cb03a");
        mTitles.add("Cooking salt");
        mProd_prices.add("$2.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P7.png?alt=media&token=1cfee4ac-7bf3-429c-b639-cc10c1c52fab");
        mTitles.add("Goji berries");
        mProd_prices.add("$5.50");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P8.png?alt=media&token=a44f73f0-316a-46e1-a0e6-b24321c56189");
        mTitles.add("Choco spread");
        mProd_prices.add("$4.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P9.png?alt=media&token=db203ca4-15e7-44d7-8b25-7b03be0b04e0");
        mTitles.add("Soya choc dessert");
        mProd_prices.add("$3.99");

        mThumbnailsUrl.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/P10.png?alt=media&token=f7083f1c-c7c6-4fe9-8c91-86236ba6a6ee");
        mTitles.add("Soya van dessert");
        mProd_prices.add("$3.99");



    }





}
