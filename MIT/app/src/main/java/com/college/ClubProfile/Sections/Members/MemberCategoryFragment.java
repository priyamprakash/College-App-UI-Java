package com.college.ClubProfile.Sections.Members;

import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.college.R;

/**
 * Common fragment for all category of club members
 * Faculties |  Members  |  Family  | Initiators  |
 */
@Keep
public class MemberCategoryFragment extends Fragment {
    private RecyclerView recyclerViewMembers;
    private MembersAdapter membersAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member_category, container, false);

        Bundle arguments = getArguments();
        String clubId = arguments.getString("string_key");
        String memberType = arguments.getString("member_type");
        String clubImage = arguments.getString("clubImage");


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewMembers = rootView.findViewById(R.id.recyclerViewMembers);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewMembers.setLayoutManager(linearLayoutManager);

//        to stop dhak - dhak state in the status bar
        Fade fade = new Fade();
        View decor = getActivity().getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        getActivity().getWindow().setEnterTransition(fade);
        getActivity().getWindow().setExitTransition(fade);


        FirebaseRecyclerOptions<MemberModel> options =
                new FirebaseRecyclerOptions.Builder<MemberModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("clubs").child(clubId).child("clubMembers").child(memberType),
                                MemberModel.class).build();


        membersAdapter = new MembersAdapter(options , clubImage);
        recyclerViewMembers.setAdapter(membersAdapter);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        membersAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        membersAdapter.stopListening();
    }
}