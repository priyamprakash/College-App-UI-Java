package com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents;

import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.ClubProfile.Sections.Members.MemberModel;
import com.mit_muzaffarpur.ClubProfile.Sections.Members.MembersAdapter;
import com.mit_muzaffarpur.R;
@Keep
public class HeldFragment extends Fragment {
    private RecyclerView recyclerViewEvents;
    private EventsAdapter eventsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView  =  inflater.inflate(R.layout.fragment_held, container, false);

        Bundle arguments = getArguments();
        String clubId = arguments.getString("string_key");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewEvents  = rootView.findViewById(R.id.recyclerViewEvents);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewEvents.setLayoutManager(linearLayoutManager);


        FirebaseRecyclerOptions<EventModel> options =
                new FirebaseRecyclerOptions.Builder<EventModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("clubs").child(clubId).child("clubEvents").child("held"),
                                EventModel.class).build();


        eventsAdapter = new EventsAdapter(options);
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