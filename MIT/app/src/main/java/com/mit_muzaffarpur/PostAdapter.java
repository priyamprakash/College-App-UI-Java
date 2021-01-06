package com.mit_muzaffarpur;

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

import me.biubiubiu.justifytext.library.JustifyTextView;

@Keep
public class PostAdapter extends FirebaseRecyclerAdapter<AlumniModel, PostAdapter.PostViewHolder> {

    private static final String TAG = "PostAdapter";

    public PostAdapter(@NonNull FirebaseRecyclerOptions<AlumniModel> options) {
        super(options);


    }

    //bind view holder
    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position,
                                    @NonNull AlumniModel alumniModel) {

        String description = alumniModel.getDescription() + "\n";
        holder.title.setText(alumniModel.getName());
        holder.description.setText(description);
        holder.author.setText(alumniModel.getAuthor());


        Log.d(TAG, "onBindViewHolder: " + holder.title.getText());

    }

    //create karne k lye
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prototype_post, parent, false);

        return new PostViewHolder(view);

    }

    //view holder reference
    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView title, author;
        JustifyTextView description;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.author);


        }
    }

}
