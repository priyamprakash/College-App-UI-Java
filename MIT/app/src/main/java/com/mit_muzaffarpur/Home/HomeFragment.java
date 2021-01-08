package com.mit_muzaffarpur.Home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.HomeFragmentElements.Club_Cell.Club_Cell_Model;
import com.mit_muzaffarpur.HomeFragmentElements.Notify.Notify_Adapter;
import com.mit_muzaffarpur.HomeFragmentElements.Notify.Notify_Model;
import com.mit_muzaffarpur.LoginSignup.StartActivity;
import com.mit_muzaffarpur.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

@Keep
public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewClubs;
    private ClubAdapter clubAdapter;

    List<Notify_Model> notifyList;
    List<Club_Cell_Model> clubList;
    RecyclerView recyclerView_notify;
    Button logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);

        logout = rootView.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), StartActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        /**
         profile pic ,email se utthakr chhipkana hai , sath me first name bhi
         */
//        CircleImageView profile_circle = rootView.findViewById(R.id.profile_circle);
//        Glide.with(this).load(R.drawable.profile_logo).placeholder(R.drawable.profile_logo).into(profile_circle);
//
//        TextView hey = rootView.findViewById(R.id.hey);
//        String first_name = "Priyam";
//        hey.setText("Hey," + "\n" + first_name + "!" );

        /**
         * Notification adapter
         */
        recyclerView_notify = (RecyclerView) rootView.findViewById(R.id.recyclerView_notify);
        LinearLayoutManager LayoutManager_notify = new LinearLayoutManager(getContext());
        LayoutManager_notify.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_notify.setLayoutManager(LayoutManager_notify);
        recyclerView_notify.setHasFixedSize(true);

        notifyList = new ArrayList<>();
        notifyList.add(
                new Notify_Model(
                        "Title",
                        "8 Dec",
                        "Description of the notification to be added here by us later as we proceed the development task"));
        notifyList.add(
                new Notify_Model(
                        "Title",
                        "8 Dec",
                        "Description of the notification to be added here by us later as we proceed the development task"));
        notifyList.add(
                new Notify_Model(
                        "Title",
                        "8 Dec",
                        "Description of the notification to be added here by us later as we proceed the development task"));


        Notify_Adapter notify_Adapter = new Notify_Adapter(getContext(), notifyList);
        recyclerView_notify.setAdapter(notify_Adapter);


//Experiment
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewClubs = rootView.findViewById(R.id.recyclerViewClubs);

        recyclerViewClubs.setHasFixedSize(true);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);//grid recycler
//        recyclerViewClubs.setLayoutManager(gridLayoutManager);//grid
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewClubs.setLayoutManager(linearLayoutManager);


        FirebaseRecyclerOptions<ClubModel> options =
                new FirebaseRecyclerOptions.Builder<ClubModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("clubs"),
                                ClubModel.class).build();


        clubAdapter = new ClubAdapter(options);
        recyclerViewClubs.setAdapter(clubAdapter);
        Log.d(TAG, "onCreate: adapter " + "Hello");

        return rootView;
    }

    //to start
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: " + "start");
        clubAdapter.startListening();
    }

    //to stop
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: " + "stop");
        clubAdapter.stopListening();
    }

}
