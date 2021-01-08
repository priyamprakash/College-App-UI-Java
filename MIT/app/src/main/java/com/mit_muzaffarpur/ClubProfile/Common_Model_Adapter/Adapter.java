package com.mit_muzaffarpur.ClubProfile.Common_Model_Adapter;

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

import me.biubiubiu.justifytext.library.JustifyTextView;

//
@Keep
public class Adapter extends FirebaseRecyclerAdapter<Model, Adapter.AchievementViewHolder> {
    public Adapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Adapter.AchievementViewHolder holder, int position, @NonNull Model model) {
        holder.message.setText(model.getMessage()+"\n");
        holder.timestamp.setText(model.getDate());
        holder.title.setText(model.getTitle());


    }

    @NonNull
    @Override
    public Adapter.AchievementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.achievement_layout, parent, false);

        return new AchievementViewHolder(view);
    }

    public class AchievementViewHolder extends RecyclerView.ViewHolder {

        TextView timestamp , title;
        JustifyTextView message;
        public AchievementViewHolder(@NonNull View itemView)

        {
            super(itemView);
            timestamp=itemView.findViewById(R.id.timestamp);
            message=itemView.findViewById(R.id.message);
            title=itemView.findViewById(R.id.title);
        }
    }
}
