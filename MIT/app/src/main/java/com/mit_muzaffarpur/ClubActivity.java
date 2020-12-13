package com.mit_muzaffarpur;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

@Keep
public class ClubActivity extends AppCompatActivity {
    private static final String TAG = "ClubActivity";
    CircleImageView logo;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView subtitle_text, description_text;
    private RecyclerView recyclerView;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        String club_name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", R.drawable.junoon_logo);
        String subtitle = getIntent().getStringExtra("subtitle");
        String description = getIntent().getStringExtra("description");

        subtitle_text = findViewById(R.id.subtitle);
        subtitle_text.setText(subtitle);
        description_text = findViewById(R.id.description);


        Button name = findViewById(R.id.club_name);
        name.setText("" + club_name);
        logo = findViewById(R.id.club_logo);
        logo.setImageResource(image);

        recyclerView = findViewById(R.id.ultimate_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        String child = club_name;


        FirebaseRecyclerOptions<Post> options =
                new FirebaseRecyclerOptions.Builder<Post>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child(child),
                                Post.class).build();

        Log.d(TAG, "onCreate: child " + FirebaseDatabase
                .getInstance().getReference().child(child));
        adapter = new PostAdapter(options);
        recyclerView.setAdapter(adapter);

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

    public void contact(View view){
        Toast.makeText(getApplicationContext(), "Idhr se email se connect kr denge",
                Toast.LENGTH_LONG).show();
    }
}