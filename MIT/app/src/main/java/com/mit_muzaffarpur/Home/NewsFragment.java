package com.mit_muzaffarpur.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.R;


public class NewsFragment extends Fragment {
    private RecyclerView recyclerViewNotifications;
    private NotificationAdapter notificationAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewNotifications  = rootView.findViewById(R.id.recycler_notification);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewNotifications.setLayoutManager(linearLayoutManager);


        FirebaseRecyclerOptions<NotificationModel> options =
                new FirebaseRecyclerOptions.Builder<NotificationModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("news"),
                                NotificationModel.class).build();


        notificationAdapter = new NotificationAdapter(options);
        recyclerViewNotifications.setAdapter(notificationAdapter);

        return  rootView;


    }

    //to start
    @Override
    public void onStart() {
        super.onStart();
        notificationAdapter.startListening();
    }

    //to stop
    @Override
    public void onStop() {
        super.onStop();
        notificationAdapter.stopListening();
    }
}