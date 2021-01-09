package com.mit_muzaffarpur.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mit_muzaffarpur.Dashboard.Alumni.Alumni;
import com.mit_muzaffarpur.Dashboard.Gallery.Gallery;
import com.mit_muzaffarpur.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView alumini = findViewById(R.id.alumini);
//        alumini.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


    }
    public  void web(View view){
        Intent intent = new Intent(getBaseContext(), Website.class);
        startActivity(intent);

    }
    public  void gallery(View view){
        Intent intent = new Intent(getBaseContext(), Gallery.class);
        startActivity(intent);

    }
    public  void alumini(View view){
        Intent intent = new Intent(getBaseContext(), Alumni.class);
        startActivity(intent);

    }

}