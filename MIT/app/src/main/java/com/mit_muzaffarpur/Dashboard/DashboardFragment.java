package com.mit_muzaffarpur.Dashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mit_muzaffarpur.Dashboard.Alumni.Alumni;
import com.mit_muzaffarpur.R;

public class DashboardFragment extends Fragment {
    @Nullable
    Button button_mit,button_dept,button_find,button_alumni;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_left,container,false);

        button_mit = rootView.findViewById(R.id.button_mit);
        button_dept = rootView.findViewById(R.id.button_dept);
        button_find = rootView.findViewById(R.id.button_find);
        button_alumni = rootView.findViewById(R.id.button_alumni);

        button_mit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(), About.class);
                view.getContext().startActivity(intent);
            }
        });


        button_dept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(), DepartmentActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        button_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:0,0?q=MIT Muzaffarpur");
//                Uri uri = Uri.parse("geo:0,0?q=\"" + 26.1413 + "," + 85.3654 + "\"");
                Intent intent4 = new Intent(android.content.Intent.ACTION_VIEW, uri);
                intent4.setPackage("com.google.android.apps.maps");
                startActivity(intent4);

            }
        });

        button_alumni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(), Alumni.class);
                view.getContext().startActivity(intent);
            }
        });

        return rootView;
    }
}
