package com.example.thebiancospinoapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    Button btnDeals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

       view.findViewById(R.id.deals_banner).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               deals_website("https://kigroup.com/offertedelmese");
           }
       });

        // Inflate the layout for this fragment
        return view;
    }

    public void deals_website(String url){

        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
