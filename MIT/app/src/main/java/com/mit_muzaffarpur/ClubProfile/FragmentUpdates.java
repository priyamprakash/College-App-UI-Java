package com.mit_muzaffarpur.ClubProfile;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mit_muzaffarpur.R;

import org.w3c.dom.Text;

import static android.content.Context.MODE_PRIVATE;


public class FragmentUpdates extends Fragment {


    public FragmentUpdates() {
        // Required empty public constructor
    }

    String clubId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_updates, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        clubId = prefs.getString("clubId", "none");
        TextView sample = rootView.findViewById(R.id.sample);
        sample.setText(clubId);
        return rootView;
    }
}