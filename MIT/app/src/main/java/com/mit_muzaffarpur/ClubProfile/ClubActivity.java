package com.mit_muzaffarpur.ClubProfile;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

import static android.content.Intent.ACTION_VIEW;

@Keep
public class ClubActivity extends AppCompatActivity {
    private static final String TAG = "ClubActivity";

    BottomNavigationView bottom_navigation;
    Fragment selectedfragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);


//getting intent values from clubAdapter

        String clubName = getIntent().getStringExtra("clubName");
        String clubImage = getIntent().getStringExtra("clubImage");
        final String clubId = getIntent().getStringExtra("clubId");
        String clubTagline = getIntent().getStringExtra("clubTagline");
        String clubDescription = getIntent().getStringExtra("clubDescription");
        final String fbLink = getIntent().getStringExtra("fb");
        String instaLink = getIntent().getStringExtra("insta");
        String linkedinLink = getIntent().getStringExtra("linkedin");
        String youtubeLink = getIntent().getStringExtra("youtube");


//name and description
        TextView club_name = findViewById(R.id.club_name);
        club_name.setText(clubName);

        TextView club_tagline = findViewById(R.id.club_tagline);
        club_tagline.setText(clubTagline);


        ImageView club_logo = findViewById(R.id.club_logo);
        Picasso.get().load(clubImage).placeholder(R.drawable.image_placeholder).into(club_logo);


        ImageView fb = findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACTION_VIEW, Uri.parse(fbLink));
                startActivity(intent);

            }
        });

        Button announcements = findViewById(R.id.announcements);
        announcements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("clubId", clubId);
                editor.apply();
//                ClubActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentAnnouncements()).commit();
                selectedfragment = new FragmentAnnouncements();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedfragment).commit();

            }
        });
        Button achievements = findViewById(R.id.achievements);
        achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("clubId", clubId);
                editor.apply();
                selectedfragment = new FragmentAchievements();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedfragment).commit();


//                ClubActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentAchievements()).commit();

            }
        });
        Button events = findViewById(R.id.events);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("clubId", clubId);
                editor.apply();
                selectedfragment = new FragmentEvents();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedfragment).commit();
//                ClubActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentEvents()).commit();

            }
        });
        Button fests = findViewById(R.id.fests);
        fests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("clubId", clubId);
                editor.apply();
                selectedfragment = new FragmentFests();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedfragment).commit();
//                ClubActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentFests()).commit();

            }
        });
        Button updates = findViewById(R.id.updates);
        updates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("clubId", clubId);
                editor.apply();
                selectedfragment = new FragmentUpdates();
//                ClubActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentUpdates()).commit();

            }
        });

        Button members = findViewById(R.id.members);
        members.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("clubId", clubId);
                editor.apply();
                selectedfragment = new FragmentMembers();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedfragment).commit();
//                ClubActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentMembers()).commit();

            }
        });


    }


    public void contact(View view) {
        Toast.makeText(getApplicationContext(), "Idhr se email se connect kr denge",
                Toast.LENGTH_LONG).show();
    }


}

