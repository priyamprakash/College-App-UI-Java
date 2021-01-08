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
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

@Keep
public class MembersAdapter extends FirebaseRecyclerAdapter<MemberModel, MembersAdapter.MemberViewHolder> {

    public MembersAdapter(@NonNull FirebaseRecyclerOptions<MemberModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MemberViewHolder holder, int position, @NonNull MemberModel model) {


        holder.Designation.setText(model.getMemberDesignation());
        holder.Department.setText(model.getMemberDepartment());
        holder.Attendance.setText(model.getMemberAttendance());
        holder.Name.setText(model.getMemberName());

        Picasso.get().load(model.getMemberImage()).placeholder(R.drawable.image_placeholder).into(holder.Image);


    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_member, parent, false);

        return new MemberViewHolder(view);
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        TextView Attendance,Department,Designation,Name;
        CircleImageView Image;
        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);


            Attendance = itemView.findViewById(R.id.Attendance);
            Department = itemView.findViewById(R.id.Department);
            Designation = itemView.findViewById(R.id.Designation);
            Name = itemView.findViewById(R.id.Name);
            Image  = itemView.findViewById(R.id.Image);

        }
    }
}
