package com.mit_muzaffarpur.Dashboard.Gallery;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.mit_muzaffarpur.Home.ClubAdapter;
import com.mit_muzaffarpur.Home.ClubModel;
import com.mit_muzaffarpur.R;

import static android.content.ContentValues.TAG;

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