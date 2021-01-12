package com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.makeramen.roundedimageview.RoundedImageView;
import com.mit_muzaffarpur.ClubProfile.Common_Model_Adapter.Adapter;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

import me.biubiubiu.justifytext.library.JustifyTextView;

/**
 * Common adapter for club events - held, ongoing and upcoming events
 */
@Keep
public class EventsAdapter extends FirebaseRecyclerAdapter<EventModel, EventsAdapter.EventViewHolder> {
    int a = 0;

    public EventsAdapter(@NonNull FirebaseRecyclerOptions<EventModel> options, int image) {
        super(options);
        a = image;
    }

    @Override
    protected void onBindViewHolder(@NonNull EventViewHolder holder, int position, @NonNull EventModel model) {

        holder.title.setText(model.getTitle());
        Picasso.get().load(model.getImage()).placeholder(R.drawable.image_placeholder).into(holder.image);

        Log.d("TAG", "onBindViewHolder: " + a);


    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if(a == 1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout, parent, false);

        }
         else
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievement_layout, parent, false);

        }

        return new EventViewHolder(view);
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        RoundedImageView image;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);


        }
    }
}
