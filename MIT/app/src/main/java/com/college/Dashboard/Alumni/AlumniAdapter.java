package com.college.Dashboard.Alumni;

import android.util.Log;
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

@Keep
public class AlumniAdapter extends FirebaseRecyclerAdapter<AlumniModel, AlumniAdapter.AlumniViewHolder> {

    private static final String TAG = "AlumniAdapter";

    public AlumniAdapter(@NonNull FirebaseRecyclerOptions<AlumniModel> options) {
        super(options);


    }

    //bind view holder
    @Override
    protected void onBindViewHolder(@NonNull AlumniViewHolder holder, int position,
                                    @NonNull AlumniModel alumniModel) {

        holder.name.setText(alumniModel.getName());
        holder.batch.setText("" +alumniModel.getBatch());
        holder.branch.setText(alumniModel.getBranch());
        holder.designation.setText(alumniModel.getDesignation());
        holder.company.setText(alumniModel.getCompany());


        Log.d(TAG, "onBindViewHolder: " + holder.name.getText());

    }

    //create karne k lye
    @NonNull
    @Override
    public AlumniViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prototype_alumni, parent, false);

        return new AlumniViewHolder(view);

    }

    //view holder reference
    class AlumniViewHolder extends RecyclerView.ViewHolder {

        TextView name, batch , branch , designation , company;


        public AlumniViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            batch = itemView.findViewById(R.id.batch);
            branch = itemView.findViewById(R.id.branch);
            designation = itemView.findViewById(R.id.designation);
            company = itemView.findViewById(R.id.company);


        }
    }

}
