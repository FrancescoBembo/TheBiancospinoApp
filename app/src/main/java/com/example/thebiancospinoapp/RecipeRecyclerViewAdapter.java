package com.example.thebiancospinoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;




public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mRecipeTitles = new ArrayList<>();
    private ArrayList<String> mPrepTime = new ArrayList<>();
    private ArrayList<String> mRecipeImg = new ArrayList<>();
    private Context mContext;


    public RecipeRecyclerViewAdapter(ArrayList<String> mRecipeTitles, ArrayList<String> mPrepTime, ArrayList<String> mRecipeImg, Context mContext) {
        this.mRecipeTitles = mRecipeTitles;
        this.mPrepTime = mPrepTime;
        this.mRecipeImg = mRecipeImg;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recipe, parent, false);
        RecipeRecyclerViewAdapter.ViewHolder holder = new RecipeRecyclerViewAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mRecipeImg.get(position))
                .into(holder.Recipe_img);

        holder.RecipeTitle.setText(mRecipeTitles.get(position));

        holder.prep_time.setText(mPrepTime.get(position));

        holder.recipe_parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, mRecipeTitles.get(position), Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return mRecipeTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView Recipe_img;
        TextView RecipeTitle;
        TextView prep_time;
        LinearLayout recipe_parent_layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Recipe_img = itemView.findViewById(R.id.Recipe_img);
            RecipeTitle = itemView.findViewById(R.id.recipe_title);
            prep_time = itemView.findViewById(R.id.prep_time);
            recipe_parent_layout = itemView.findViewById(R.id.recipe_parent_layout);
        }
    }
}
