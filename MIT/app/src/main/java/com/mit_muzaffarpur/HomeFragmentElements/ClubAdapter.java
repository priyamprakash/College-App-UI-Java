package com.mit_muzaffarpur.HomeFragmentElements;

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
import com.makeramen.roundedimageview.RoundedImageView;
import com.mit_muzaffarpur.ClubProfile.ClubActivity;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

@Keep
public class ClubAdapter extends FirebaseRecyclerAdapter<ClubModel, ClubAdapter.ClubViewHolder> {
    private static final String TAG = "ClubAdapter";

    public ClubAdapter(@NonNull FirebaseRecyclerOptions<ClubModel> options) {
        super(options);


    }
    @Override
    protected void onBindViewHolder(@NonNull ClubViewHolder holder, int position,
                                    @NonNull final ClubModel clubModel)
    {

        Log.d(TAG, "onBindViewHolder: clubName  " + "Hello");
        Log.d(TAG, "onBindViewHolder: clubName  " + clubModel.getClubName());
        Picasso.get().load(clubModel.getClubImage()).placeholder(R.drawable.image_placeholder).into(holder.clubImage);
        holder.clubName.setText(clubModel.getClubName());


        holder.clubImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(),ClubActivity.class);
                intent.putExtra("clubId", clubModel.getClubId());
                intent.putExtra("clubImage",clubModel.getClubImage());
                intent.putExtra("clubName",clubModel.getClubName());
                intent.putExtra("clubTagline", clubModel.getClubTagline());
                intent.putExtra("clubDescription", clubModel.getClubDescription());
                intent.putExtra("fb",clubModel.getClubFacebookLink());
                intent.putExtra("insta",clubModel.getClubInstaLink());
                intent.putExtra("linkedin",clubModel.getClubLinkedinLink());
                intent.putExtra("youtube",clubModel.getClubYoutubeLink());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);

            }
        });

    }
    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.prototype_club_cell, parent , false);

        return new ClubViewHolder(view);

    }


    //view holder reference
    class ClubViewHolder extends RecyclerView.ViewHolder {

        TextView clubName ;
        RoundedImageView clubImage;
        public ClubViewHolder(@NonNull View itemView) {
            super(itemView);
            clubName=itemView.findViewById(R.id.clubName);
            clubImage = itemView.findViewById(R.id.clubImage);

        }
    }

}
