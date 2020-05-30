package com.example.thebiancospinoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipesFragment extends Fragment {

    public RecipesFragment() {
        // Required empty public constructor
    }

    private ArrayList<String> mRecipeTitles = new ArrayList<>();
    private ArrayList<String> mPrepTime = new ArrayList<>();
    private ArrayList<String> mRecipeImgUrls = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_recipes, container, false);
        initRecipeImageBitmaps();
        RecyclerView recyclerView = view.findViewById(R.id.recipe_recycler_view);
        RecipeRecyclerViewAdapter adapter = new RecipeRecyclerViewAdapter(mRecipeTitles, mPrepTime, mRecipeImgUrls, this.getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));




        // Inflate the layout for this fragment
        return view;
    }

    private void initRecipeImageBitmaps(){

        mRecipeImgUrls.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/Recipes%2Fr2.png?alt=media&token=7d99f2e5-b330-419a-8d9c-9087f0cecfa4");
        mRecipeTitles.add("Potato wedges");
        mPrepTime.add("1h, 30min");

        mRecipeImgUrls.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/Recipes%2Fr3.png?alt=media&token=2971b40a-41ab-4e00-9cb2-9628050212c6");
        mRecipeTitles.add("Mini shredded chicken tostadas");
        mPrepTime.add("35min");

        mRecipeImgUrls.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/Recipes%2Fr4.png?alt=media&token=33602381-dcfa-4db6-96e4-e9d7472a5ef4");
        mRecipeTitles.add("Peri peri chicken");
        mPrepTime.add("1h, 20min");

        mRecipeImgUrls.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/Recipes%2Fr5.png?alt=media&token=a0c00c0a-251d-4797-bd65-fe6c7e868c6b");
        mRecipeTitles.add("Deviled eggs");
        mPrepTime.add("25min");

        mRecipeImgUrls.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/Recipes%2Fr6.png?alt=media&token=8fdcb94f-65cf-4da7-892a-5cfef3e9bea1");
        mRecipeTitles.add("Spring veg with miso");
        mPrepTime.add("20min");

        mRecipeImgUrls.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/Recipes%2Fr7.png?alt=media&token=ab653095-ab58-4f0a-99c5-c91d949c3011");
        mRecipeTitles.add("Quesadillas with spinach and beans");
        mPrepTime.add("40min");

        mRecipeImgUrls.add("https://firebasestorage.googleapis.com/v0/b/thebiancospinoapp.appspot.com/o/Recipes%2Fr1.png?alt=media&token=81cfaea7-f2f6-435c-bcf2-ca9ba438ffc0");
        mRecipeTitles.add("recipe");
        mPrepTime.add("30min");


    }

}
