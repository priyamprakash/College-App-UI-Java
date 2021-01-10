package com.mit_muzaffarpur.ClubProfile.Common_Model_Adapter;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.mit_muzaffarpur.R;

import me.biubiubiu.justifytext.library.JustifyTextView;

/**
 * Common adapter for club notifications , achievements , announcements
 */
@Keep
public class Adapter extends FirebaseRecyclerAdapter<Model, Adapter.AchievementViewHolder> {
    public Adapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Adapter.AchievementViewHolder holder, int position, @NonNull final Model model) {
        holder.message.setText("" + model.getMessage() + "\n");
        holder.timestamp.setText(model.getDate());
        holder.title.setText(model.getTitle());

        if(model.getClicktext() == null){
            holder.click.setText("CLICK HERE");
        }
        else{
            holder.click.setText(model.getClicktext());
        }

        holder.click.setVisibility(View.GONE);
        if (model.getLink() != null) {
            holder.click.setVisibility(View.VISIBLE);
            holder.click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  try{
                      Intent i = new Intent(Intent.ACTION_VIEW);
                      i.setData(Uri.parse(model.getLink()));
                      view.getContext().startActivity(i);
                  }
                  catch (Exception e){
                      Log.d("Adapter", "onClick: error" + e);
                      Toast.makeText(view.getContext(), "Oops! Something went wrong", Toast.LENGTH_SHORT).show();
                  }


                }
            });
        }


    }

    @NonNull
    @Override
    public Adapter.AchievementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.achievement_layout, parent, false);

        return new AchievementViewHolder(view);
    }

    public class AchievementViewHolder extends RecyclerView.ViewHolder {

        TextView timestamp, title, click;
        JustifyTextView message;

        public AchievementViewHolder(@NonNull View itemView) {
            super(itemView);
            timestamp = itemView.findViewById(R.id.timestamp);
            message = itemView.findViewById(R.id.message);
            title = itemView.findViewById(R.id.title);
            click = itemView.findViewById(R.id.click);
        }
    }
}
