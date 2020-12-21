package com.mit_muzaffarpur.ClubProfile;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.R;

import static android.content.Context.MODE_PRIVATE;

@Keep
public class FragmentMembers extends Fragment {
    private RecyclerView recyclerViewMembers;
    private MembersAdapter membersAdapter;

String clubId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_members, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        clubId = prefs.getString("clubId", "none");




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewMembers  = rootView.findViewById(R.id.recyclerViewMembers);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewMembers.setLayoutManager(linearLayoutManager);


        FirebaseRecyclerOptions<MemberModel> options =
                new FirebaseRecyclerOptions.Builder<MemberModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("clubs").child(clubId).child("clubMembers").child("faculties"),
                                MemberModel.class).build();


        membersAdapter = new  MembersAdapter(options);
        recyclerViewMembers.setAdapter(membersAdapter);

        Button faculties = rootView.findViewById(R.id.faculties);
        faculties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        return  rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        membersAdapter.startListening();
    }

    //to stop
    @Override
    public void onStop() {
        super.onStop();
        membersAdapter.stopListening();
    }


}