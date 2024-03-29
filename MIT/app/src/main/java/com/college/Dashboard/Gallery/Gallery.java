package com.college.Dashboard.Gallery;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.college.R;

@Keep
public class Gallery extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GalleryAdapter galleryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerGallery);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);//grid recycler
        gridLayoutManager.setReverseLayout(true);//to reverse the order of images
//        gridLayoutManager.setStackFromEnd(true); // GridLayoutManager does not support stack from end bro
        recyclerView.setLayoutManager(gridLayoutManager);



        FirebaseRecyclerOptions<GalleryModel> options =
                new FirebaseRecyclerOptions.Builder<GalleryModel>()
                        .setQuery(FirebaseDatabase
                                        .getInstance().getReference().child("gallery"),
                                GalleryModel.class).build();


        galleryAdapter = new GalleryAdapter(options);
        recyclerView.setAdapter(galleryAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        galleryAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        galleryAdapter.stopListening();
    }

}