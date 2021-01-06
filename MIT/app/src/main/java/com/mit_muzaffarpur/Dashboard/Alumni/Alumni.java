package com.mit_muzaffarpur.Dashboard.Alumni;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.R;

@Keep
public class Alumni extends AppCompatActivity {
    private static final String TAG = "Alumni";
    private RecyclerView recyclerView;
    private AlumniAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni);
        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);


        FirebaseRecyclerOptions<AlumniModel> options =
                new FirebaseRecyclerOptions.Builder<AlumniModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("alumni"),
                                AlumniModel.class).build();



        adapter = new AlumniAdapter(options);
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreate: adapter "+ adapter);

    }

    //to start
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    //to stop
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}