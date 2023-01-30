package com.college.Dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.college.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
@Keep
public class DeptFactAdapter extends FirebaseRecyclerAdapter<DeptFactModel , DeptFactAdapter.DeptFactViewHolder> {

    public DeptFactAdapter(FirebaseRecyclerOptions<DeptFactModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull DeptFactViewHolder holder, int position, @NonNull DeptFactModel model) {

        holder.name.setText(model.getName());
        holder.designation.setText(model.getDesignation());
        Picasso.get().load(model.getImage()).into(holder.image);


    }

    @NonNull
    @Override
    public DeptFactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prototype_dept_fact, parent, false);

        return new DeptFactViewHolder(view);    }

    public class DeptFactViewHolder extends RecyclerView.ViewHolder {
        TextView name,designation;
        CircleImageView image;
        public DeptFactViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            designation = itemView.findViewById(R.id.designation);

            image = itemView.findViewById(R.id.image);
        }
    }
}
