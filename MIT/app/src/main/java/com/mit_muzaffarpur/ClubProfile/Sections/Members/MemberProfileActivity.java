package com.mit_muzaffarpur.ClubProfile.Sections.Members;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mit_muzaffarpur.R;
import com.squareup.picasso.Picasso;

public class MemberProfileActivity extends AppCompatActivity {

    RoundedImageView image;
    TextView Name, position;
    TextView name, designation, department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_profile);
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        image = findViewById(R.id.image);
        Name = findViewById(R.id.Name);
        position = findViewById(R.id.position);
        String i = getIntent().getStringExtra("image");
        String n = getIntent().getStringExtra("name");
        String d = getIntent().getStringExtra("position");


        Picasso.get().load(i).placeholder(R.drawable.placeholder_person).into(image);
        Name.setText(n);
        position.setText(d);

        //------------------------------------------- neeche vala card ----------------------------

        name = findViewById(R.id.name);
        designation = findViewById(R.id.designation);
        department = findViewById(R.id.department);
        String desig = getIntent().getStringExtra("designation");
        String dept = getIntent().getStringExtra("department");

        name.setText(n);
        designation.setText(desig);
        department.setText(dept);



    }
}