package com.mit_muzaffarpur.ClubProfile;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.Bottom.ClubAdapter;
import com.mit_muzaffarpur.ClubProfile.Announcements.AnnouncementModel;
import com.mit_muzaffarpur.R;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

@Keep
public class FragmentAnnouncements extends Fragment {

    private RecyclerView recyclerViewAnnouncements;
    private AnnouncementAdapter announcementAdapter;

  public FragmentAnnouncements() {
        // Required empty public constructor
    }
    String clubId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_announcements, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        clubId = prefs.getString("clubId", "none");
        TextView sample = rootView.findViewById(R.id.sample);
        sample.setText("Club Id:    "+clubId);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewAnnouncements  = rootView.findViewById(R.id.recyclerViewAnnouncements);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewAnnouncements.setLayoutManager(linearLayoutManager);



    FirebaseRecyclerOptions<AnnouncementModel> options =
            new FirebaseRecyclerOptions.Builder<AnnouncementModel>()
                    .setQuery(FirebaseDatabase
                                    .getInstance().getReference().child("clubs").child(clubId).child("clubAnnouncements"),
                            AnnouncementModel.class).build();


    announcementAdapter = new AnnouncementAdapter(options);
    recyclerViewAnnouncements.setAdapter(announcementAdapter);



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