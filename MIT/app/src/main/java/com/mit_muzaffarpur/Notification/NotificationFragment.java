package com.mit_muzaffarpur.Notification;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.R;

@Keep
public class NotificationFragment extends Fragment {
    private RecyclerView recyclerViewNotifications;
    private NotificationAdapter notificationAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView  =  inflater.inflate(R.layout.fragment_notification,container,false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewNotifications  = rootView.findViewById(R.id.recycler_notification);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewNotifications.setLayoutManager(linearLayoutManager);


        FirebaseRecyclerOptions<NotificationModel> options =
                new FirebaseRecyclerOptions.Builder<NotificationModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("notifications"),
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
