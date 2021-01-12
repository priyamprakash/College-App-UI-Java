package com.mit_muzaffarpur.ClubProfile.Sections.Members;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.makeramen.roundedimageview.RoundedImageView;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

@Keep
public class MembersAdapter extends FirebaseRecyclerAdapter<MemberModel, MembersAdapter.MemberViewHolder> {
    public MembersAdapter(@NonNull FirebaseRecyclerOptions<MemberModel> options , String clubImage) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MemberViewHolder holder, int position, @NonNull MemberModel model) {


        holder.Designation.setText(model.getDesignation());
        holder.Name.setText(model.getName());
        Picasso.get().load(model.getImage()).placeholder(R.drawable.placeholder_person).into(holder.image);


    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_member, parent, false);

        return new MemberViewHolder(view);
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        TextView Designation,Name;
        RoundedImageView  image;
        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);

//            Department = itemView.findViewById(R.id.Department);
            Designation = itemView.findViewById(R.id.designation);
            Name = itemView.findViewById(R.id.Name);
            image  = itemView.findViewById(R.id.image);

        }
    }
}
