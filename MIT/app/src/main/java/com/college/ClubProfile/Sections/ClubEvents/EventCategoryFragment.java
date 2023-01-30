package com.college.ClubProfile.Sections.ClubEvents;

import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.college.R;

/**
 * Common fragment for all types of club Events
 * Held |  Ongoing  |  Upcoming |
 */

@Keep
public class EventCategoryFragment extends Fragment {
    private RecyclerView recyclerViewEvents;
    private EventsAdapter eventsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView  =  inflater.inflate(R.layout.fragment_held, container, false);

        Bundle arguments = getArguments();
        String clubId = arguments.getString("string_key");
        String clubName = arguments.getString("club_name");
        String event_status =arguments.getString("event_status");
        Log.d("EventCategoryFragment", "onCreateView: " + clubName + event_status);


//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        linearLayoutManager.setReverseLayout(true);
//        linearLayoutManager.setStackFromEnd(true);
//        recyclerViewEvents.setLayoutManager(linearLayoutManager);

        recyclerViewEvents  = rootView.findViewById(R.id.recyclerViewEvents);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);//grid recycler
        gridLayoutManager.setReverseLayout(true);
        recyclerViewEvents.setLayoutManager(gridLayoutManager);


        FirebaseRecyclerOptions<EventModel> options =
                new FirebaseRecyclerOptions.Builder<EventModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("clubs").child(clubId).child("clubEvents").child(event_status),
                                EventModel.class).build();


        eventsAdapter = new EventsAdapter(options, 1 , clubName , event_status );
        recyclerViewEvents.setAdapter(eventsAdapter);

        return  rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        eventsAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        eventsAdapter.stopListening();
    }
}