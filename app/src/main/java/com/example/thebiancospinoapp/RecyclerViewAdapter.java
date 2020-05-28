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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mProd_prices = new ArrayList<>();
    private ArrayList<String> mThumbnails = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mTitles, ArrayList<String> mProd_prices, ArrayList<String> mThumbnails, Context mContext) {
        this.mTitles = mTitles;
        this.mProd_prices = mProd_prices;
        this.mThumbnails = mThumbnails;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mThumbnails.get(position))
                .into(holder.thumbnail);

        holder.title.setText(mTitles.get(position));

        holder.prod_price.setText(mProd_prices.get(position));

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, mTitles.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView thumbnail;
        TextView title;
        TextView prod_price;
        LinearLayout parent_layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            prod_price = itemView.findViewById(R.id.prod_price);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
