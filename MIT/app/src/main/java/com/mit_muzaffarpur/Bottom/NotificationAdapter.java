package com.mit_muzaffarpur.Bottom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.mit_muzaffarpur.ClubProfile.AchievementAdapter;
import com.mit_muzaffarpur.R;

import org.w3c.dom.Text;


@Keep
public class NotificationAdapter extends FirebaseRecyclerAdapter<NotificationModel, NotificationAdapter.NotificationViewHolder> {

    public NotificationAdapter(@NonNull FirebaseRecyclerOptions<NotificationModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NotificationViewHolder holder, int position, @NonNull NotificationModel model) {


        holder.title.setText(model.getNotificationTitle());

        holder.link.setText(model.getNotificationLink());
        holder.desc.setText(model.getNotificationDescription());
        holder.timestamp.setText(model.getNotificationTimestamp());
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_layout, parent, false);

        return new NotificationAdapter.NotificationViewHolder(view);
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        TextView title,desc, link,timestamp;
        public NotificationViewHolder(@NonNull View itemView)
        {

            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.description);
            link = itemView.findViewById(R.id.link);
            timestamp = itemView.findViewById(R.id.timestamp);

        }
    }
}
