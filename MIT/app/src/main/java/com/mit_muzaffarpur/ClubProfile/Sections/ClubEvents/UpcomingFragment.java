package com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit_muzaffarpur.R;

public  class UpcomingFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView  =  inflater.inflate(R.layout.fragment_upcoming, container, false);

        return rootView;
    }
}