package com.mit_muzaffarpur.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mit_muzaffarpur.R;
import com.mit_muzaffarpur.Website;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView alumini = findViewById(R.id.alumini);
        alumini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
    public  void web(View view){
        Intent intent = new Intent(getBaseContext(), Website.class);
        startActivity(intent);

    }
    public  void dept(View view){
        Intent intent = new Intent(getBaseContext(), DepartmentActivity.class);
        startActivity(intent);

    }

}