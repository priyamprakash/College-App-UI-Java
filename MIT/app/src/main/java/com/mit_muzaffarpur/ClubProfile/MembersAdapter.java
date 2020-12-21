package com.mit_muzaffarpur.ClubProfile;


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
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member_layout, parent, false);

        return new MemberViewHolder(view);
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        TextView Attendance,Department,Designation,Name;
        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);


            Attendance = itemView.findViewById(R.id.Attendance);
            Department = itemView.findViewById(R.id.Department);
            Designation = itemView.findViewById(R.id.Designation);
            Name = itemView.findViewById(R.id.Name);

        }
    }
}
