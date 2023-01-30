package com.college.ClubProfile.Sections.Members;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.makeramen.roundedimageview.RoundedImageView;
import com.college.R;
import com.squareup.picasso.Picasso;

@Keep
public class MembersAdapter extends FirebaseRecyclerAdapter<MemberModel, MembersAdapter.MemberViewHolder> {
    public MembersAdapter(@NonNull FirebaseRecyclerOptions<MemberModel> options, String clubImage) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final MemberViewHolder holder, int position, @NonNull final MemberModel model) {

        holder.position.setText(model.getPosition());
        holder.Name.setText(model.getName());
        Picasso.get().load(model.getImage()).placeholder(R.drawable.placeholder_person).into(holder.image);

        holder.member_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(view.getContext(), MemberProfileActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("name", model.getName());
                intent.putExtra("position", model.getPosition());
                intent.putExtra("designation", model.getDesignation());
                intent.putExtra("department", model.getDepartment());


                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(holder.image, "imageTransition");
                pairs[1] = new Pair<View, String>(holder.Name, "nameTransition");
                pairs[2] = new Pair<View, String>(holder.position, "positionTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) view.getContext(), pairs);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent, options.toBundle());
//                ((Activity) view.getContext()).overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

            }
        });

        setScaleAnimation(holder.itemView);

    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_member, parent, false);

        return new MemberViewHolder(view);
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        TextView position, Name;
        RoundedImageView image;
        LinearLayout member_card;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);

//            Department = itemView.findViewById(R.id.Department);
            position = itemView.findViewById(R.id.position);
            Name = itemView.findViewById(R.id.Name);
            image = itemView.findViewById(R.id.image);
            member_card = itemView.findViewById(R.id.member_card);

        }

    }

}
