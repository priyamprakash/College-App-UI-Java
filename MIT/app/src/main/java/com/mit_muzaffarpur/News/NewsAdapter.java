package com.mit_muzaffarpur.News;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

import me.biubiubiu.justifytext.library.JustifyTextView;


@Keep
public class NewsAdapter extends FirebaseRecyclerAdapter<NewsModel, NewsAdapter.NotificationViewHolder> {

    public NewsAdapter(@NonNull FirebaseRecyclerOptions<NewsModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NotificationViewHolder holder, int position, @NonNull NewsModel model) {

        String t = model.getNotificationTitle().substring(0,1).toUpperCase() + model.getNotificationTitle().substring(1);
        holder.title.setText(t);
        holder.link.setText(model.getNotificationLink());
        holder.desc.setText(model.getNotificationDescription() + "\n");
        holder.timestamp.setText(model.getNotificationTimestamp());
        Picasso.get().load(model.notificationImage).into(holder.notification_image);

//        if(position%2 == 0)
//        {
//            holder.layout.setBackgroundResource(R.drawable.tool);
//            holder.desc.setTextColor(Color.parseColor("#FFFFFF"));
//            holder.title.setTextColor(Color.parseColor(("#FFFFFF")));
//        }
//        else
//        {
//            holder.layout.setBackgroundResource(R.drawable.white);
//            holder.desc.setTextColor(Color.parseColor("#252827"));
//            holder.title.setTextColor(Color.parseColor(("#252827")));
//
//        }



    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news, parent, false);

        return new NewsAdapter.NotificationViewHolder(view);
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        TextView title, link,timestamp;
        JustifyTextView desc;
        ImageView notification_image;
        LinearLayout layout;
        public NotificationViewHolder(@NonNull View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.description);
            link = itemView.findViewById(R.id.link);
            timestamp = itemView.findViewById(R.id.timestamp);
            notification_image  = itemView.findViewById(R.id.notification_image);
            layout = itemView.findViewById(R.id.layout);

        }
    }
}
