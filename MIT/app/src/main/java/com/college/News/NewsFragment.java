package com.college.News;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.college.R;


public class NewsFragment extends Fragment {
    private RecyclerView recyclerViewNotifications;
    private NewsAdapter newsAdapter;
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


        FirebaseRecyclerOptions<NewsModel> options =
                new FirebaseRecyclerOptions.Builder<NewsModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("news"),
                                NewsModel.class).build();


        newsAdapter = new NewsAdapter(options);
        recyclerViewNotifications.setAdapter(newsAdapter);

        return  rootView;


    }

    //to start
    @Override
    public void onStart() {
        super.onStart();
        newsAdapter.startListening();
    }

    //to stop
    @Override
    public void onStop() {
        super.onStop();
        newsAdapter.stopListening();
    }
}