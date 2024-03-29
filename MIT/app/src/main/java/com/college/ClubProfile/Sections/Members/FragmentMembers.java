package com.college.ClubProfile.Sections.Members;

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
import com.college.R;

import static android.content.Context.MODE_PRIVATE;

@Keep
public class FragmentMembers extends Fragment {

    TabLayout tabLayout;
    FrameLayout frameLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    String clubId ,clubImage , clubName;
    String memberType = "faculties"; //first tab ke naam se initiate
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_members, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        clubId = prefs.getString("clubId", "none");
        clubImage = prefs.getString("clubImage" ,clubImage);
        clubName = prefs.getString("clubName", "none");


        tabLayout=(TabLayout)rootView.findViewById(R.id.tabLayout);
        frameLayout=(FrameLayout)rootView.findViewById(R.id.frameLayout);

        fragment = new MemberCategoryFragment();
        fragmentManager = getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        Bundle arguments = new Bundle();
        arguments.putString( "string_key" , clubId);
        arguments.putString("member_type", memberType);

        fragment.setArguments(arguments);

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

/**
 * Tab
 * FACULTIES | MEMBERS  |  FAMILY | INITIATORS  |
 */

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new MemberCategoryFragment();
                        memberType = "faculties";
                        break;
                    case 1:
                        fragment = new MemberCategoryFragment();
                        memberType = "members";
                        break;
                    case 2:
                        fragment = new MemberCategoryFragment();
                        memberType = "family";
                        break;
                    case 3:
                        fragment = new MemberCategoryFragment();
                        memberType = "initiators";
                        break;
                }

                FragmentManager fm = getChildFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                Bundle arguments = new Bundle();
                arguments.putString( "string_key" , clubId);
                arguments.putString("member_type", memberType);
                arguments.putString("club_image" , clubImage);

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