package com.example.thebiancospinoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    String name;
    TextView username;

    public AccountFragment(String name) {
        // Required empty public constructor
        this.name = name;

    }


    Button btnShowBarcode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        btnShowBarcode = view.findViewById(R.id.showBarcodeBTN);
        username = view.findViewById(R.id.username);
        username.setText(name);








        // Inflate the layout for this fragment
        return view;
    }
}
