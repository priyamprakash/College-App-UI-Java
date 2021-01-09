package com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;
import com.mit_muzaffarpur.R;

import static android.content.Context.MODE_PRIVATE;

@Keep
public class FragmentEvents extends Fragment {
    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String clubId ;
    String event_status = "held";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        clubId = prefs.getString("clubId", "none");

        tabLayout=(TabLayout)rootView.findViewById(R.id.tabLayout);
        frameLayout=(FrameLayout)rootView.findViewById(R.id.frameLayout);

        fragment = new EventCategoryFragment();
        fragmentManager = getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        Bundle arguments = new Bundle();
        arguments.putString( "string_key" , clubId);
        arguments.putString("event_status" ,  event_status);

        fragment.setArguments(arguments);

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

/**
 * Tab
 * HELD | ONGOING  |  UPCOMING
 */

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new EventCategoryFragment();
                        event_status = "held";
                        break;
                    case 1:
                        fragment = new EventCategoryFragment();
                        event_status = "ongoing";
                        break;
                    case 2:
                        fragment = new EventCategoryFragment();
                        event_status = "upcoming";
                        break;

                }

                FragmentManager fm = getChildFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                Bundle arguments = new Bundle();
                arguments.putString( "string_key" , clubId);
                arguments.putString("event_status" ,  event_status);

                fragment.setArguments(arguments);

                ft.replace(R.id.frameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return  rootView;
    }

}