package com.example.thebiancospinoapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;



/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    String name;
    TextView username;
    String personPhoto;
    ImageView photo;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    public AccountFragment(String name, String personPhoto) {
        // Required empty public constructor
        this.name = name;
        this.personPhoto = personPhoto;
    }


    Button btnLogout;
    Button btnShowBarcode;
//    BottomSheetBehavior mBottomSheetBehavior;
//    LinearLayout mBottomSheet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);


        username = view.findViewById(R.id.username);
        username.setText(name);


        photo = view.findViewById(R.id.userPic);
        Picasso.get().load(personPhoto).into(photo);

        btnLogout = view.findViewById(R.id.logoutBtn);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });









        btnShowBarcode = view.findViewById(R.id.showBarcodeBTN);
        btnShowBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
//      mBottomSheet = view.findViewById(R.id.barcode_bottom_sheet);
//
//        mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);
//
//        btnShowBarcode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//
//            }
//        });








        // Inflate the layout for this fragment
        return view;
    }
}
