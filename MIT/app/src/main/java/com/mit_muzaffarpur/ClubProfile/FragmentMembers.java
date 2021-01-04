package com.mit_muzaffarpur.ClubProfile;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.AboutMIT.Fragment_one;
import com.mit_muzaffarpur.AboutMIT.Fragment_two;
import com.mit_muzaffarpur.R;

import static android.content.Context.MODE_PRIVATE;

@Keep
public class FragmentMembers extends Fragment {

    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    String clubId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_members, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        clubId = prefs.getString("clubId", "none");

        tabLayout=(TabLayout)rootView.findViewById(R.id.tabLayout);
        frameLayout=(FrameLayout)rootView.findViewById(R.id.frameLayout);

        fragment = new FragmentMembersFaculties();
        fragmentManager = getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        Bundle arguments = new Bundle();//tukka
        arguments.putString( "string_key" , clubId);//tukka
        fragment.setArguments(arguments);//tukka

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new FragmentMembersFaculties();
                        break;
                    case 1:
                        fragment = new FragmentMemberMember();
                        break;
                    case 2:
                        fragment = new FragmentMemberFamily();
                        break;
                    case 3:
                        fragment = new FragmentMemberInitiators();
                        break;
                }

                FragmentManager fm = getChildFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                Bundle arguments = new Bundle();//tukka
                arguments.putString( "string_key" , clubId);//tukka
                fragment.setArguments(arguments);//tukka

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