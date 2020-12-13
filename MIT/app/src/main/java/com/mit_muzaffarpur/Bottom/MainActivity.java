package com.mit_muzaffarpur.Bottom;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.mit_muzaffarpur.AboutMIT.About;
import com.mit_muzaffarpur.AppInfo;
import com.mit_muzaffarpur.HomeFragment_Elements.Drawer.DrawerItem;
import com.mit_muzaffarpur.HomeFragment_Elements.Drawer.Drawer_Adapter;
import com.mit_muzaffarpur.HomeFragment_Elements.Drawer.SimpleItem;
import com.mit_muzaffarpur.HomeFragment_Elements.Drawer.SpaceItem;
import com.mit_muzaffarpur.R;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements Drawer_Adapter.OnItemSelectedListener{

    final String TAG ="Main_Meow";

    MeowBottomNavigation meo;
    private final static int ID_HOME=1;
    private final static int ID_LOGIN=2;
    private final static int ID_ABOUT=3;

    private static final int POS_DASHBOARD = 0;
    private static final int POS_ABOUT = 1;
    private static final int DEPARTMENT = 4;
    private static final int POS_EVENTS = 3;
    private static final int POS_APP_INFO = 2;
    private static final int POS_LOGOUT = 5;
    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_meow);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        /**
         Toolbar
         */
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


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
                createItemFor(POS_APP_INFO),
                new SpaceItem(260),
                createItemFor(POS_LOGOUT)));
        drawer_adapter.setListener(this);

        RecyclerView list = findViewById(R.id.drawer_list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(drawer_adapter);

        drawer_adapter.setListener(this);

        meo=(MeowBottomNavigation)findViewById(R.id.bottom_nav);
        meo.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_dashboard_24));
        meo.add(new MeowBottomNavigation.Model(2,R.drawable.ic_baseline_dashboard_24));
        meo.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_dashboard_24));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        meo.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"Clicked item"+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });
        meo.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"Clicked item"+item.getId(),Toast.LENGTH_SHORT).show();

            }
        });
        meo.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment select_fragment = null;
                switch (item.getId()){
                    case ID_HOME:
                        select_fragment=new LeftFragment();
                        break;
                    case ID_LOGIN:
                        select_fragment=new HomeFragment();
                        break;
                    case ID_ABOUT:
                        select_fragment=new NotificationFragment();
                        break;
                    default:
                        select_fragment=new HomeFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,select_fragment).commit();
            }
        });


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
            Log.d(TAG, "loadScreenIcons: " + i);
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


        if(position == POS_EVENTS)
        {
            Toast.makeText(getApplicationContext(), "User Profile",
                    Toast.LENGTH_LONG).show();
        }
        if (position == DEPARTMENT) {
            Toast.makeText(getApplicationContext(), "Sare Branch ka detail",
                    Toast.LENGTH_LONG).show();

        }

        if(position == POS_APP_INFO)
        {
            Intent intent = new Intent(getBaseContext(), AppInfo.class);
            startActivity(intent);
        }
        if (position == POS_LOGOUT) {
            finish();
        }

        slidingRootNav.closeMenu();
    }

}