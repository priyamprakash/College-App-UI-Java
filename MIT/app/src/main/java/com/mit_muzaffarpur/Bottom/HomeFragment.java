package com.mit_muzaffarpur.Bottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mit_muzaffarpur.HomeFragment_Elements.Club_Cell.Club_Cell_Model;
import com.mit_muzaffarpur.HomeFragment_Elements.Club_Cell.Club_Cell_adapter;
import com.mit_muzaffarpur.HomeFragment_Elements.Notify.Notify_Adapter;
import com.mit_muzaffarpur.HomeFragment_Elements.Notify.Notify_Model;
import com.mit_muzaffarpur.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    //a list to store all the products
    List<Notify_Model> notifyList;
    List<Club_Cell_Model> clubList;
    //    List<Youtube_Model> ytList;
    RecyclerView recyclerView_notify, recyclerView, recyclerView_cell , recyclerView_yt;
    RecyclerView.LayoutManager layoutManager_club;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  rootView = inflater.inflate(R.layout.fragment_meow_home,container,false);


        /**
         profile pic ,email se utthakr chhipkana hai , sath me first name bhi
         */
        CircleImageView profile_circle = rootView.findViewById(R.id.profile_circle);
        Glide.with(this).load(R.drawable.profile_logo).placeholder(R.drawable.profile_logo).into(profile_circle);

        TextView hey = rootView.findViewById(R.id.hey);
        String first_name = "Priyam";
        hey.setText("Hey," + "\n" + first_name + "!" );

        /**
         * Notification adapter
         */
        recyclerView_notify = (RecyclerView) rootView.findViewById(R.id.recyclerView_notify);
        LinearLayoutManager LayoutManager_notify = new LinearLayoutManager(getContext());
        LayoutManager_notify.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_notify.setLayoutManager(LayoutManager_notify);
        recyclerView_notify.setHasFixedSize(true);

        notifyList = new ArrayList<>();
        notifyList.add(
                new Notify_Model(
                        "Title",
                        "8 Dec",
                        "Description of the notification to be added here by us later as we proceed the development task"));
        notifyList.add(
                new Notify_Model(
                        "Title",
                        "8 Dec",
                        "Description of the notification to be added here by us later as we proceed the development task"));
        notifyList.add(
                new Notify_Model(
                        "Title",
                        "8 Dec",
                        "Description of the notification to be added here by us later as we proceed the development task"));


        Notify_Adapter notify_Adapter = new Notify_Adapter(getContext(), notifyList);
        recyclerView_notify.setAdapter(notify_Adapter);

        /**
         * Clubs adapter
         */

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setHasFixedSize(true);
        clubList = new ArrayList<>();
        clubList.add(
                new Club_Cell_Model(
                        "junoon",
                        "The Arts & Cultural Club",
                        "Achha sa description to be added here",
                        1,
                        "",
                        R.drawable.junoon_logo));
        clubList.add(
                new Club_Cell_Model(
                        "moxie",
                        "The Technical Club",
                        "Achha sa description to be added here",
                        2,
                        "",
                        R.drawable.moxie_logo));
        clubList.add(
                new Club_Cell_Model(
                        "udgam",
                        "The sports Club",
                        "Achha sa description to be added here",
                        3,
                        "",
                        R.drawable.udgam_logo));
        //creating recyclerview ka adapter
        Club_Cell_adapter club_Cell_adapter = new Club_Cell_adapter(getContext(), clubList);
        recyclerView.setAdapter(club_Cell_adapter);

        /**
         * Cells adapter
         */

        recyclerView_cell = (RecyclerView) rootView.findViewById(R.id.recyclerView_cell);
        LinearLayoutManager cell_layout_manager = new LinearLayoutManager(getContext());
        cell_layout_manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_cell.setLayoutManager(cell_layout_manager);

        recyclerView_cell.setHasFixedSize(true);
        clubList = new ArrayList<>();
        clubList.add(
                new Club_Cell_Model(
                        "startup",
                        "Startup - need of the generation",
                        "Achha sa description to be added here",
                        1,
                        "",
                        R.drawable.startup_cell_logo));
        clubList.add(
                new Club_Cell_Model(
                        "innovation",
                        "Startup - need of the generation",
                        "Achha sa description to be added here",
                        2,
                        "",
                        R.drawable.moxie_logo));
        clubList.add(
                new Club_Cell_Model(
                        "placement",
                        "Startup - need of the generation",
                        "Achha sa description to be added here",
                        3,
                        "",
                        R.drawable.udgam_logo));
        //creating recyclerview ka adapter
        Club_Cell_adapter cell_adapter = new Club_Cell_adapter(getContext(), clubList);
        recyclerView_cell.setAdapter(cell_adapter);


        /**
         * Youtube adapter
         */

        recyclerView_yt = (RecyclerView) rootView.findViewById(R.id.recyclerView_youtube);
        LinearLayoutManager yt_layout_manager = new LinearLayoutManager(getContext());
        yt_layout_manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_yt.setLayoutManager(yt_layout_manager);

        recyclerView_yt.setHasFixedSize(true);

    return  rootView;
    }



}
