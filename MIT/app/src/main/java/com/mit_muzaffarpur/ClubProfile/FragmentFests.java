package com.mit_muzaffarpur.ClubProfile;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit_muzaffarpur.R;

import static android.content.Context.MODE_PRIVATE;

public class FragmentFests extends Fragment {



    public FragmentFests() {

    }

    String clubId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fests, container, false);


        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        clubId = prefs.getString("clubId", "none");

        return rootView;
    }
}

