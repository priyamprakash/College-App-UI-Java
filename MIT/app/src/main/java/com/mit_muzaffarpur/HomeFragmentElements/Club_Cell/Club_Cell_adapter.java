package com.mit_muzaffarpur.HomeFragmentElements.Club_Cell;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.mit_muzaffarpur.ClubProfile.ClubActivity;
import com.mit_muzaffarpur.R;

import java.util.List;

/**
 * Club_Adapter for Main Activity
 */


public class Club_Cell_adapter extends RecyclerView.Adapter<Club_Cell_adapter.FounderViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Club_Cell_Model> clubList;

    //getting the context and product list with constructor
    public Club_Cell_adapter(Context mCtx, List<Club_Cell_Model> clubList) {
        this.mCtx = mCtx;
        this.clubList = clubList;
    }


    @Override
    public FounderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.prototype_club_cell, null);
        return new FounderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FounderViewHolder holder, int position) {
        //getting the product of the specified position
        final Club_Cell_Model obj = clubList.get(position);

       final int image =  obj.getImage();
        String url = obj.getUrl();
        holder.imageView.setImageResource(obj.getImage());

        final String clubname =  obj.getName();
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(mCtx , ClubActivity.class);
                intent.putExtra("name",clubname);
                intent.putExtra("image" ,image);
                intent.putExtra("subtitle" , obj.getSubtitle());
                intent.putExtra("description",obj.getDescription());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //important for intent in adapter
                mCtx.startActivity(intent);
            }
        });



//        Glide.with(mCtx)
//                .load(url)
//                .placeholder(R.drawable.junoon_logo)
//                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return clubList.size();
    }


    class FounderViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public FounderViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
