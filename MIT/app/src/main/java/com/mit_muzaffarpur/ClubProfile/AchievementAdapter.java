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

import me.biubiubiu.justifytext.library.JustifyTextView;

//
@Keep
public class AchievementAdapter extends FirebaseRecyclerAdapter<AchievementModel, AchievementAdapter.AchievementViewHolder> {
    public AchievementAdapter(@NonNull FirebaseRecyclerOptions<AchievementModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AchievementAdapter.AchievementViewHolder holder, int position, @NonNull AchievementModel model) {
        holder.message.setText(model.getAchievementMessage()+"\n");
        holder.timestamp.setText(model.getAchievementDate());
        holder.title.setText(model.getAchievementTitle());


    }

    @NonNull
    @Override
    public AchievementAdapter.AchievementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
