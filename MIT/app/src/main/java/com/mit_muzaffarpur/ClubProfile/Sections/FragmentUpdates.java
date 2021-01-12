package com.mit_muzaffarpur.ClubProfile.Sections;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.ClubProfile.Common_Model_Adapter.Adapter;
import com.mit_muzaffarpur.ClubProfile.Common_Model_Adapter.Model;
import com.mit_muzaffarpur.R;

import static android.content.Context.MODE_PRIVATE;


public class FragmentUpdates extends Fragment {
    private RecyclerView recyclerViewUpdates;
    private Adapter announcementAdapter;
    String clubId , clubImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_updates, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        clubId = prefs.getString("clubId", "none");
        clubImage = prefs.getString("clubImage" ,clubImage);

        TextView sample = rootView.findViewById(R.id.sample);
        sample.setText(clubId);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewUpdates  = rootView.findViewById(R.id.recyclerViewUpdates);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewUpdates.setLayoutManager(linearLayoutManager);



        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("clubs").child(clubId).child("clubNotifications"),
                                Model.class).build();


        announcementAdapter = new Adapter(options);
        recyclerViewUpdates.setAdapter(announcementAdapter);



        return rootView;

    }
    //to start
    @Override
    public void onStart() {
        super.onStart();
        announcementAdapter.startListening();
    }

    //to stop
    @Override
    public void onStop() {
        super.onStop();
        announcementAdapter.stopListening();
    }


}