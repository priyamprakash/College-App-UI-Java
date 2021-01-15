package com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.makeramen.roundedimageview.RoundedImageView;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

/**
 * Common adapter for club events - held, ongoing and upcoming events
 */
@Keep
public class EventsAdapter extends FirebaseRecyclerAdapter<EventModel, EventsAdapter.EventViewHolder> {
    int a = 0;
    String status = "" , clubName= "";

    public EventsAdapter(@NonNull FirebaseRecyclerOptions<EventModel> options, int image, String clubName , String status) {
        super(options);
        this.a = image;
        this.status = status;
        this.clubName=  clubName;
        Log.d("EventsAdapter", "EventsAdapter: " + clubName);
    }

    @Override
    protected void onBindViewHolder(@NonNull final EventViewHolder holder, int position, @NonNull final EventModel model) {

        holder.title.setText(model.getTitle());
        Picasso.get().load(model.getImage()).placeholder(R.drawable.placeholder_image).into(holder.image);


        holder.event_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(view.getContext(), EventProfileActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("title", model.getTitle());
                intent.putExtra("description", model.getDescription());
                Log.d("EventAdapter", "onClick: " + model.getDescription());
// --------------------
                intent.putExtra("clubName", clubName);
                intent.putExtra("status", status);




                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(holder.image, "imageTransition");
                pairs[1] = new Pair<View, String>(holder.title, "titleTransition");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) view.getContext(), pairs);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent, options.toBundle());
//                ((Activity) view.getContext()).overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

            }
        });


        setScaleAnimation(holder.itemView);

    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(1000);
        view.startAnimation(anim);
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
        LinearLayout  event_card;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            event_card  = itemView.findViewById(R.id.event_card);


        }
    }
}
