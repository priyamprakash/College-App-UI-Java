package com.mit_muzaffarpur.ClubProfile.Sections.ClubEvents;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class EventProfileActivity extends AppCompatActivity {
    final String TAG = "EventProfileActivity";
    RoundedImageView image;
    ImageView blur;
    TextView title ,clubName ,  status , description;

    BlurView blurView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_profile);

        blur = findViewById(R.id.blur);

        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        status = findViewById(R.id.status);
        clubName = findViewById(R.id.club_name);

        CircleImageView indicator =  findViewById(R.id.indicator);
        indicator.setVisibility(View.INVISIBLE);

        String i = getIntent().getStringExtra("image");
        String t = getIntent().getStringExtra("title");
        String d = getIntent().getStringExtra("designation");
        String desc = getIntent().getStringExtra("description");
        String clubName1 = getIntent().getStringExtra("clubName");
        String status1 = getIntent().getStringExtra("status");



        Picasso.get().load(i).placeholder(R.drawable.placeholder_person).into(blur);
        Picasso.get().load(i).placeholder(R.drawable.placeholder_person).into(image);
        title.setText(t);
        Log.d("EventProfileActivity", "onCreate: " + clubName1);
        clubName.setText("Organised by : " +clubName1);
        description.setText("Description : " + desc + "\n");
        status.setText("Status : " + status1.substring(0,1).toUpperCase() + status1.substring(1).toLowerCase());
        if(status1.equalsIgnoreCase("ongoing"))
        {
            indicator.setVisibility(View.VISIBLE);
        }
        else{
            indicator.setVisibility(View.INVISIBLE);

        }


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