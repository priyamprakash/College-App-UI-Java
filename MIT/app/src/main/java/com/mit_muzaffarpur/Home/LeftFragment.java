package com.mit_muzaffarpur.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mit_muzaffarpur.Dashboard.About;
import com.mit_muzaffarpur.Dashboard.DepartmentActivity;
import com.mit_muzaffarpur.R;

public class LeftFragment extends Fragment {
    @Nullable
    Button button_mit,button_dept;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_left,container,false);

        button_mit = rootView.findViewById(R.id.button_mit);
        button_dept = rootView.findViewById(R.id.button_dept);

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





        return rootView;
    }
}
