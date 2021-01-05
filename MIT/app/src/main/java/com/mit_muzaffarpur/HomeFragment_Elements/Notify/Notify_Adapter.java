package com.mit_muzaffarpur.HomeFragment_Elements.Notify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.mit_muzaffarpur.R;

import java.util.List;

import me.biubiubiu.justifytext.library.JustifyTextView;

/**
 * Notify_Adapter for Main Activity
 */


public class Notify_Adapter extends RecyclerView.Adapter<Notify_Adapter.NotifyViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Notify_Model> notifyList;

    //getting the context and product list with constructor
    public Notify_Adapter(Context mCtx, List<Notify_Model> notifyList) {
        this.mCtx = mCtx;
        this.notifyList = notifyList;
    }

    @Override
    public NotifyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.prototype_notify, null);
        return new NotifyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(NotifyViewHolder holder, int position) {
        //getting the product of the specified position
        Notify_Model notify = notifyList.get(position);
        holder.Title.setText(notify.getTitle());
        holder.Date.setText(notify.getDate());
        holder.description.setText(notify.getDescription() + "\n");

        if(position%2 == 0)
        {
            holder.notifyLayout.setBackgroundResource(R.drawable.tool);
        }
        else
        {
            holder.notifyLayout.setBackgroundResource(R.drawable.white);
            holder.description.setTextColor(R.color.colorPrimaryDark);
        }



//        Glide.with(mCtx)
//                .load(url)
//                .placeholder(R.drawable.junoon_logo)
//                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return notifyList.size();
    }


    class NotifyViewHolder extends RecyclerView.ViewHolder {

        TextView Title , Date;
        JustifyTextView description;
        ConstraintLayout notifyLayout;
        public NotifyViewHolder(View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.notify_title);
            Date = itemView.findViewById(R.id.notify_date);
            description = itemView.findViewById(R.id.notify_description);
            notifyLayout = itemView.findViewById(R.id.notifyLayout);
        }
    }
}
