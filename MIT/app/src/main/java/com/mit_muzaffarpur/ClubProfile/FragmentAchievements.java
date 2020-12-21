package com.mit_muzaffarpur.ClubProfile;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.ClubProfile.Announcements.AnnouncementModel;
import com.mit_muzaffarpur.R;

import static android.content.Context.MODE_PRIVATE;

@Keep
public class FragmentAchievements extends Fragment {

    private RecyclerView recyclerViewAchievements;
    private AchievementAdapter achievementAdapter;

    public FragmentAchievements() {
        // Required empty public constructor
    }

    String clubId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_achievements, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        clubId = prefs.getString("clubId", "none");
        TextView sample = rootView.findViewById(R.id.sample);
        sample.setText("Club Id:    " + clubId);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewAchievements = rootView.findViewById(R.id.recyclerViewAchievements);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewAchievements.setLayoutManager(linearLayoutManager);


        FirebaseRecyclerOptions<AchievementModel> options =
                new FirebaseRecyclerOptions.Builder<AchievementModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("clubs").child(clubId).child("clubAchievements"),
                                AchievementModel.class).build();

        achievementAdapter = new AchievementAdapter(options);
        recyclerViewAchievements.setAdapter(achievementAdapter);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        achievementAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        achievementAdapter.stopListening();
    }
}