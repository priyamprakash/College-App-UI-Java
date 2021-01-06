package com.mit_muzaffarpur.Dashboard;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit_muzaffarpur.Dashboard.Alumni.AlumniAdapter;
import com.mit_muzaffarpur.R;

@Keep
public class DepartmentActivity extends AppCompatActivity {
    private static final String TAG = "DepartmentActivity";
    private RecyclerView recyclerView;
    private AlumniAdapter adapter;
    TabLayout tabLayout;
    TextView dept_id, dept_name , dept_intro , dept_vision , dept_mission;
    String intro, vision,mission = "";
    String deptId = "1";

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department);

        dept_id = findViewById(R.id.dept_id);
        dept_name = findViewById(R.id.dept_name);
        dept_intro = findViewById(R.id.intro);
        dept_vision = findViewById(R.id.vision);
        dept_mission = findViewById(R.id.mission);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

//------------------- Jab koi tab na selected ho
        databaseReference = FirebaseDatabase
                .getInstance().getReference().child("departments").child(deptId);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String id = snapshot.child("deptId").getValue().toString();
                String name = snapshot.child("deptName").getValue().toString();
               try {
                   intro = snapshot.child("deptIntro").getValue().toString();
                   vision = snapshot.child("deptVision").getValue().toString();
                   mission = snapshot.child("deptMission").getValue().toString();
               }
               catch (Exception e)
               {
                   Log.d(TAG, "onDataChange: error" + e);
               }
                dept_id.setText(id);
                dept_name.setText(name);
                dept_intro.setText(intro + "\n");
                dept_vision.setText(vision + "\n");
                dept_mission.setText(mission + "\n");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//---------><---------



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i = tab.getPosition() + 1;
                Log.d(TAG, "onTabSelected: i =  " + i);
                deptId = "" + i;
//-------------------
                databaseReference = FirebaseDatabase
                        .getInstance().getReference().child("departments").child(deptId);
                databaseReference.keepSynced(true);//nitish sir firebase hack

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String id = snapshot.child("deptId").getValue().toString();
                        String name = snapshot.child("deptName").getValue().toString();
                        try {
                            intro = snapshot.child("deptIntro").getValue().toString();
                            vision = snapshot.child("deptVision").getValue().toString();
                            mission = snapshot.child("deptMission").getValue().toString();
                        }
                        catch (Exception e)
                        {
                            Log.d(TAG, "onDataChange: error" + e);
                        }
                        dept_id.setText(id);
                        dept_name.setText(name);
                        dept_intro.setText(intro + "\n");
                        dept_vision.setText(vision + "\n");
                        dept_mission.setText(mission + "\n");

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//---------><---------

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }





}