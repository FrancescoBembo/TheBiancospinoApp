package com.example.thebiancospinoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder> {


    private Context context;
    private List<AppModel> appList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    /** create myviewholder class **/
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView card_title, card_item_price;
        public ImageView card_thumbnail;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing view
            card_title = itemView.findViewById(R.id.card_title);
            card_item_price = itemView.findViewById(R.id.card_item_price);
            card_thumbnail = itemView.findViewById(R.id.card_thumbnail);

        }
    }


    /** variables and constructors **/

    public AppAdapter(Context context, List<AppModel> appList) {
        this.context = context;
        this.appList = appList;
    }


    /** implementing methods of adapter **/



}
