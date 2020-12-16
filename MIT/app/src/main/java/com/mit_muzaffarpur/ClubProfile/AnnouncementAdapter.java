package com.mit_muzaffarpur.ClubProfile;

import android.content.Intent;
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
import com.mit_muzaffarpur.ClubProfile.Announcements.AnnouncementModel;
import com.mit_muzaffarpur.R;

import me.biubiubiu.justifytext.library.JustifyTextView;


@Keep
public class AnnouncementAdapter extends FirebaseRecyclerAdapter<AnnouncementModel , AnnouncementAdapter.AnnouncementViewHolder>{

    public AnnouncementAdapter(@NonNull FirebaseRecyclerOptions<AnnouncementModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AnnouncementAdapter.AnnouncementViewHolder holder, int position, @NonNull AnnouncementModel model) {

        holder.message.setText(model.getAnnouncementMessage()+"\n");
        holder.timestamp.setText(model.getAnnouncementTimestamp());
        holder.title.setText(model.getAnnouncementTitle());

    }

    @NonNull
    @Override
    public AnnouncementAdapter.AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.announcement_layout, parent , false);

        return new AnnouncementViewHolder(view);
    }

    public class AnnouncementViewHolder extends RecyclerView.ViewHolder {

        TextView timestamp , title;
        JustifyTextView message;
        public AnnouncementViewHolder(@NonNull View itemView) {

            super(itemView);
            timestamp=itemView.findViewById(R.id.timestamp);
            message=itemView.findViewById(R.id.message);
            title=itemView.findViewById(R.id.title);

        }
    }
}