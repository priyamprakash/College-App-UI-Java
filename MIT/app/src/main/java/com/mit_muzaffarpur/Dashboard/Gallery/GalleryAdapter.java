package com.mit_muzaffarpur.Dashboard.Gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.makeramen.roundedimageview.RoundedImageView;
import com.mit_muzaffarpur.Dashboard.Alumni.AlumniAdapter;
import com.mit_muzaffarpur.Dashboard.Alumni.AlumniModel;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

@Keep
public class GalleryAdapter extends FirebaseRecyclerAdapter<GalleryModel, GalleryAdapter.GalleryViewHolder> {

    public GalleryAdapter(@NonNull FirebaseRecyclerOptions<GalleryModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull GalleryViewHolder holder, int position, @NonNull GalleryModel model) {

        Picasso.get().load(model.getImage()).placeholder(R.drawable.image_placeholder).into(holder.image);


    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prototype_gallery, parent, false);

        return new GalleryViewHolder(view);
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView image;
        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
        }
    }
}
