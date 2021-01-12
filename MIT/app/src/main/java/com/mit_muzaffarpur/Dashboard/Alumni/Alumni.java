package com.mit_muzaffarpur.Dashboard.Alumni;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.R;

@Keep
public class Alumni extends AppCompatActivity {
    private static final String TAG = "Alumni";
    private RecyclerView recyclerView;
    private AlumniAdapter adapter;
    Button alumni_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni);

        alumni_register = findViewById(R.id.alumni_register);
        alumni_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.mitmuzaffarpur.org/alumni-registration/"));
                startActivity(i);
            }
        });

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

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}