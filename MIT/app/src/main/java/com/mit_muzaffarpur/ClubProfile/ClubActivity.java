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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.mit_muzaffarpur.ClubProfile.Sections.ClubAchievement.FragmentAchievements;
import com.mit_muzaffarpur.ClubProfile.Sections.Announcement.FragmentAnnouncements;
import com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents.FragmentEvents;
import com.mit_muzaffarpur.ClubProfile.Sections.FragmentFests;
import com.mit_muzaffarpur.ClubProfile.Sections.Members.FragmentMembers;
import com.mit_muzaffarpur.ClubProfile.Sections.FragmentUpdates;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

import static android.content.Intent.ACTION_VIEW;

@Keep
public class ClubActivity extends AppCompatActivity {
    private static final String TAG = "ClubActivity";

    Fragment selectedfragment = null;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);


//getting intent values from clubAdapter

        String clubName = getIntent().getStringExtra("clubName");
        final String clubImage = getIntent().getStringExtra("clubImage");
        final String clubId = getIntent().getStringExtra("clubId");
        String clubTagline = getIntent().getStringExtra("clubTagline");

        String clubDescription = getIntent().getStringExtra("clubDescription");
        final String fbLink = getIntent().getStringExtra("fb");
        String instaLink = getIntent().getStringExtra("insta");
        String linkedinLink = getIntent().getStringExtra("linkedin");
        String youtubeLink = getIntent().getStringExtra("youtube");


//name and description
        /**
         * Club name & Intro
         */
        TextView club_name = findViewById(R.id.club_name);
        club_name.setText(clubName);

        TextView club_tagline = findViewById(R.id.club_tagline);
        club_tagline.setText(clubTagline);


        ImageView club_logo = findViewById(R.id.club_logo);
        Picasso.get().load(clubImage).placeholder(R.drawable.image_placeholder).into(club_logo);


//        ImageView fb = findViewById(R.id.fb);
//        fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ACTION_VIEW, Uri.parse(fbLink));
//                startActivity(intent);
//
//            }
//        });

/**
 * Tab
 * UPDATES | ANNOUNCEMENTS  |  EVENTS | FESTS | TEAM | ACHIEVEMENTS  |  ABOUT
 */

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

// jab kch na selected ho :
        selectedfragment = new FragmentUpdates();
        SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
        editor.putString("clubId", clubId);
        editor.apply();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedfragment).commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:

                        selectedfragment = new FragmentUpdates();

                        break;
                    case 1:

                        selectedfragment = new FragmentAnnouncements();

                        break;
                    case 2:

                        selectedfragment = new FragmentEvents();

                        break;
                    case 3:
                        selectedfragment = new FragmentFests();

                        break;
                    case 4:

                        selectedfragment = new FragmentMembers();
                        break;
                    case 5:

                        selectedfragment = new FragmentAchievements();

                        break;

                }
//                sharing the clubID
                SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("clubId", clubId);
                editor.putString("clubImage",clubImage);
                editor.apply();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedfragment).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }

    /**
     * Floating Action Button
     * @param view
     */
    public void contact(View view) {
        Toast.makeText(getApplicationContext(), "Idhr se email se connect kr denge",
                Toast.LENGTH_LONG).show();
    }


}

