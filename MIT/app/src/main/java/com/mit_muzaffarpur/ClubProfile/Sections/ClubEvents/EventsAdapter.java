package com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.mit_muzaffarpur.ClubProfile.Common_Model_Adapter.Adapter;
import com.mit_muzaffarpur.R;

import me.biubiubiu.justifytext.library.JustifyTextView;

/**
 * Common adapter for club events - held, ongoing and upcoming events
 */
@Keep
public class EventsAdapter  extends FirebaseRecyclerAdapter<EventModel ,EventsAdapter.EventViewHolder> {
        public EventsAdapter(@NonNull FirebaseRecyclerOptions<EventModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull EventViewHolder holder, int position, @NonNull EventModel model) {

            holder.title.setText(model.getTitle());
            holder.description.setText(model.getDescription() + "\n");
            holder.date.setText(model.getDate());
            holder.time.setText(model.getTime());

    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_layout, parent, false);

        return new EventViewHolder(view);
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        TextView time,date , title;
        JustifyTextView description;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            time=itemView.findViewById(R.id.time);
            date=itemView.findViewById(R.id.date);
            description=itemView.findViewById(R.id.description);

        }
    }
}
