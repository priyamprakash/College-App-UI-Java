package com.mit_muzaffarpur.Home;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mit_muzaffarpur.AboutMIT.About;
import com.mit_muzaffarpur.AboutMIT.Department_Activity;
import com.mit_muzaffarpur.Home.Club_Cell.Club_Cell_Model;
import com.mit_muzaffarpur.Home.Club_Cell.Club_Cell_adapter;
import com.mit_muzaffarpur.Home.Navigation_Drawer.DrawerItem;
import com.mit_muzaffarpur.Home.Navigation_Drawer.Drawer_Adapter;
import com.mit_muzaffarpur.Home.Notify.Notify_Adapter;
import com.mit_muzaffarpur.Home.Notify.Notify_Model;
import com.mit_muzaffarpur.R;
import com.mit_muzaffarpur.Home.Navigation_Drawer.SimpleItem;
import com.mit_muzaffarpur.Home.Navigation_Drawer.SpaceItem;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements Drawer_Adapter.OnItemSelectedListener {

    private static final int POS_ABOUT = 0;
    private static final int POS_DASHBOARD = 1;
    private static final int DEPARTMENT = 2;
    private static final int POS_EVENTS = 3;
    private static final int POS_SETTINGS = 4;
    private static final int POS_ABOUT_US = 5;
    private static final int POS_LOGOUT = 5;
    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;


    //a list to store all the products
    List<Notify_Model> notifyList;
    List<Club_Cell_Model> clubList;
    RecyclerView recyclerView_notify, recyclerView, recyclerView_cell;
    RecyclerView.LayoutManager layoutManager_club;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /**
         Toolbar
         */
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        /**
         profile pic ,email se utthakr chhipkana hai , sath me first name bhi
         */
        CircleImageView profile_circle = findViewById(R.id.profile_circle);
        Glide.with(this).load(R.drawable.profile_logo).placeholder(R.drawable.profile_logo).into(profile_circle);

        TextView hey = findViewById(R.id.hey);
        String first_name = "Priyam";
        hey.setText("Hey," + "\n" + first_name + "!" );

        /**
        * Notification adapter
        */
        recyclerView_notify = (RecyclerView) findViewById(R.id.recyclerView_notify);
        LinearLayoutManager LayoutManager_notify = new LinearLayoutManager(getApplicationContext());
        LayoutManager_notify.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_notify.setLayoutManager(LayoutManager_notify);
        recyclerView_notify.setHasFixedSize(true);

        notifyList = new ArrayList<>();
        notifyList.add(
                new Notify_Model(
                        "Title",
                        "8 Dec",
                        "Description of the notification to be added here by us later as we proceed the development task"));
        notifyList.add(
                new Notify_Model(
                        "Title",
                        "8 Dec",
                        "Description of the notification to be added here by us later as we proceed the development task"));
        notifyList.add(
                new Notify_Model(
                        "Title",
                        "8 Dec",
                        "Description of the notification to be added here by us later as we proceed the development task"));


        Notify_Adapter notify_Adapter = new Notify_Adapter(this, notifyList);
        recyclerView_notify.setAdapter(notify_Adapter);

        /**
         * Clubs adapter
         */

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setHasFixedSize(true);
        clubList = new ArrayList<>();
        clubList.add(
                new Club_Cell_Model(
                        1,
                        "",
                        R.drawable.junoon_logo));
        clubList.add(
                new Club_Cell_Model(
                        2,
                        "",
                        R.drawable.moxie_logo));
        clubList.add(
                new Club_Cell_Model(
                        3,
                        "",
                        R.drawable.udgam_logo));
        //creating recyclerview ka adapter
        Club_Cell_adapter club_Cell_adapter = new Club_Cell_adapter(this, clubList);
        recyclerView.setAdapter(club_Cell_adapter);

        /**
         * Cells adapter
         */

        recyclerView_cell = (RecyclerView) findViewById(R.id.recyclerView_cell);
        LinearLayoutManager cell_layout_manager = new LinearLayoutManager(getApplicationContext());
        cell_layout_manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_cell.setLayoutManager(cell_layout_manager);

        recyclerView_cell.setHasFixedSize(true);
        clubList = new ArrayList<>();
        clubList.add(
                new Club_Cell_Model(
                        1,
                        "",
                        R.drawable.startup_cell_logo));
        clubList.add(
                new Club_Cell_Model(
                        2,
                        "",
                        R.drawable.moxie_logo));
        clubList.add(
                new Club_Cell_Model(
                        3,
                        "",
                        R.drawable.udgam_logo));
        //creating recyclerview ka adapter
        Club_Cell_adapter cell_adapter = new Club_Cell_adapter(this, clubList);
        recyclerView_cell.setAdapter(cell_adapter);





        /**
         *neeche right side find button , green color - Google map par intent
         * latitude - 26.1413 , longitude - 85.3654
         * Pincode - 842003
         */

        Button button_find;
        button_find = findViewById(R.id.button_find);
        button_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Uri uri = Uri.parse("geo:0,0?q=\"" + 26.1413 + "," + 85.3654 + "\"");
                Uri uri = Uri.parse("geo:0,0?q=MIT,Muzaffarpur");
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });


        /**Bloody navigation drawer
         */

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withDragDistance(180)
                .withRootViewScale(0.75f)
                .withRootViewElevation(25)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_menu)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();
//        color(R.color.colorAccent);

        Drawer_Adapter drawer_adapter = new Drawer_Adapter(Arrays.asList(
                createItemFor(POS_ABOUT),
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(DEPARTMENT),
                createItemFor(POS_EVENTS),
                createItemFor(POS_SETTINGS),
                createItemFor(POS_DASHBOARD),
                createItemFor(POS_ABOUT_US),
                new SpaceItem(260),
                createItemFor(POS_LOGOUT)));
        drawer_adapter.setListener(this);

        RecyclerView list = findViewById(R.id.drawer_list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(drawer_adapter);

        drawer_adapter.setListener(this);
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withNormalIconTint(color(R.color.colorPrimaryDark))
                .withNormalTextTint(color(R.color.colorPrimaryDark))
                .withSelectedIconTint(color(R.color.dark_yellow))
                .withSelectedTextTint(color(R.color.dark_yellow));
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.id_activityScreenTitles);

    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.id_activityScreenIcon);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);

            }
        }
        ta.recycle();
        return icons;
    }


    //    NAVIGATION DRAWER KA SARA ITEMS
    @Override
    public void onItemSelected(int position) {
        if (position == POS_ABOUT) {

            Intent intent = new Intent(getBaseContext(), About.class);
            startActivity(intent);

        }

        if (position == DEPARTMENT) {
            Intent intent = new Intent(getBaseContext(), Department_Activity.class);
            startActivity(intent);

        }
        if (position == POS_LOGOUT) {
            finish();
        }

        slidingRootNav.closeMenu();
    }


    /**
     * On back pressed
     */

    @Override
    public void onBackPressed() {
        finish();
    }
}