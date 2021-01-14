package com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class EventProfileActivity extends AppCompatActivity {
    RoundedImageView image;
    ImageView blur;
    TextView title;

    BlurView blurView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_profile);

        blur = findViewById(R.id.blur);

        image = findViewById(R.id.image);
        title = findViewById(R.id.title);


        String i = getIntent().getStringExtra("image");
        String t = getIntent().getStringExtra("title");
        String d = getIntent().getStringExtra("designation");


        Picasso.get().load(i).placeholder(R.drawable.placeholder_person).into(blur);
        Picasso.get().load(i).placeholder(R.drawable.placeholder_person).into(image);
        title.setText(t);

        blurView = findViewById(R.id.blur_layout);
        blurBackground();


    }
  private void blurBackground(){
      float radius = 20f;

      View decorView = getWindow().getDecorView();
      ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);

      Drawable windowBackground = decorView.getBackground();

      blurView.setupWith(rootView)
              .setFrameClearDrawable(windowBackground)
              .setBlurAlgorithm(new RenderScriptBlur(this))
              .setBlurRadius(radius)
              .setBlurAutoUpdate(true)
              .setHasFixedTransformationMatrix(true);
  }


}