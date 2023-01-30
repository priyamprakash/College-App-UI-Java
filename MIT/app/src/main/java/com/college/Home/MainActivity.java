package com.college.Home;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.college.Dashboard.About;
import com.college.Dashboard.AppInfo;
import com.college.Dashboard.DashboardFragment;
import com.college.HomeFragmentElements.Drawer.DrawerItem;
import com.college.HomeFragmentElements.Drawer.Drawer_Adapter;
import com.college.HomeFragmentElements.Drawer.SimpleItem;
import com.college.HomeFragmentElements.Drawer.SpaceItem;
import com.college.News.NewsFragment;
import com.college.Notification.NotificationFragment;
import com.college.R;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;
import java.util.Objects;

@Keep
public class MainActivity extends AppCompatActivity implements Drawer_Adapter.OnItemSelectedListener {

    final String TAG = "Main_Meow";
    private int REQUEST_CODE = 11;

    MeowBottomNavigation meo;
    private final static int ID_LEFT = 1;
    private final static int ID_HOME = 2;
    private final static int ID_NOTIFICATION = 3;
    private final static int ID_NEWS = 4;

    //---------------------------------------------------
    private static final int POS_DASHBOARD = 0;
    private static final int POS_ABOUT = 1;
    private static final int POS_APP_INFO = 3;
    private static final int DEPARTMENT = 2;
    private static final int POS_PROFILE = 4;
    private static final int POS_LOGOUT = 5;
    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;
    TextView name, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_meow);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//----------------------IF YOU WANT TO DISPLAY THE NAME AND GMAIL PROFILE PIC
//        Button logout = findViewById(R.id.logout);
//        name = findViewById(R.id.name);
//        mail = findViewById(R.id.mail);
//
//
//        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
//        if (signInAccount != null) {
//            name.setText(signInAccount.getDisplayName());
//            mail.setText(signInAccount.getEmail());
//        }

        /**
         * PUSH NOTIFICATIONS, SUBSCRIBING TO GENERAL TOPIC
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel("MyNotifications", "MyNotifications",
                            NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            Objects.requireNonNull(manager).createNotificationChannel(channel);
        }


//subscribing to push notification , topic= general

        final String type = "general";
        FirebaseMessaging.getInstance().subscribeToTopic(type)
                .addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successful";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                        Log.d(TAG, "onComplete push" + msg);
                        Toast.makeText(MainActivity.this, "Subscribed to " + type, Toast.LENGTH_LONG).show();
                    }
                });

        /**
         *App Update
         */
        final AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(MainActivity.this);
        com.google.android.play.core.tasks.Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
        appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
            @Override
            public void onSuccess(AppUpdateInfo result) {
                if (result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                        && result.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                    try {
                        appUpdateManager.startUpdateFlowForResult(result, AppUpdateType.IMMEDIATE, MainActivity.this, REQUEST_CODE);
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

        /**
         *App Rating Dialog
         */
        //app rating option
//        AppRate.with(this)
//                .setStoreType(StoreType.GOOGLEPLAY)
//                .setInstallDays((byte) 0) // default 10, 0 means install day
//                .setLaunchTimes((byte) 3) // default 10
//                .setRemindInterval((byte) 2) // default 1
//                .setRemindLaunchTimes((byte) 2) // default 1 (each launch)
//                .setShowLaterButton(true) // default true
//                .setDebug(false)// default false
//
//                .setOnClickButtonListener(new OnClickButtonListener() { // callback listener.
//                    @Override
//                    public void onClickButton(byte which) {
//                        Log.d(MainActivity.class.getName(), Byte.toString(which));
//                    }
//                })
//                .monitor();
//
//        if (AppRate.with(this).getStoreType() == StoreType.GOOGLEPLAY) {
//            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this) != ConnectionResult.SERVICE_MISSING) {
//                AppRate.showRateDialogIfMeetsConditions(this);
//            }
//        } else {

//            AppRate.showRateDialogIfMeetsConditions(this);
//        }

        /**
         Toolbar
         */
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("MIT ");
//        getSupportActionBar().setSubtitle("Muzaffarpur");

        /**Navigation drawer
         */

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withDragDistance(225)
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
//        color(R.color.white);

        Drawer_Adapter drawer_adapter = new Drawer_Adapter(Arrays.asList(
                createItemFor(POS_ABOUT),
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(DEPARTMENT),
                createItemFor(POS_PROFILE),
                createItemFor(POS_APP_INFO),
                new SpaceItem(260),
                createItemFor(POS_LOGOUT)));
        drawer_adapter.setListener(this);

        RecyclerView list = findViewById(R.id.drawer_list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(drawer_adapter);

        drawer_adapter.setListener(this);

        meo = (MeowBottomNavigation) findViewById(R.id.bottom_nav);
        meo.add(new MeowBottomNavigation.Model(1, R.drawable.ic_dashboard));
        meo.add(new MeowBottomNavigation.Model(2, R.drawable.ic_home));
        meo.add(new MeowBottomNavigation.Model(3, R.drawable.ic_notifications));
        meo.add(new MeowBottomNavigation.Model(4, R.drawable.ic_news));


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        meo.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(),"Clicked item"+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });
        meo.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(),"Clicked item"+item.getId(),Toast.LENGTH_SHORT).show();

            }
        });


        meo.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment select_fragment = null;
                switch (item.getId()) {
                    case ID_LEFT:
                        select_fragment = new DashboardFragment();
                        break;
                    case ID_HOME:
                        select_fragment = new HomeFragment();
                        break;
                    case ID_NOTIFICATION:
                        select_fragment = new NotificationFragment();
                        break;
                    case ID_NEWS:
                        select_fragment = new NewsFragment();
                        break;
                    default:
                        select_fragment = new HomeFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, select_fragment).commit();
            }
        });


    }

    //for app update code
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            Toast.makeText(this, "Start DOWNLOAD", Toast.LENGTH_SHORT).show();
            if (requestCode != REQUEST_CODE) {
                Log.d(TAG, "onActivityResult: " + resultCode);

            }
        }


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


        if (position == POS_APP_INFO) {
            Intent intent = new Intent(getBaseContext(), AppInfo.class);
            startActivity(intent);
        }
        if (position == DEPARTMENT) {
            Toast.makeText(getApplicationContext(), "Sare Branch ka detail",
                    Toast.LENGTH_LONG).show();

        }
        if (position == POS_PROFILE) {
            Toast.makeText(getApplicationContext(), "User Profile",
                    Toast.LENGTH_LONG).show();
        }
        if (position == POS_LOGOUT) {
            finish();
        }

        slidingRootNav.closeMenu();
    }

}