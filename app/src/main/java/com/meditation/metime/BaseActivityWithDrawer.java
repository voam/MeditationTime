package com.meditation.metime;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public abstract class BaseActivityWithDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FrameLayout contentFrame;
    DrawerLayout leftDrawer;

    private static String email = "info@meditatetoregenerate.org";


    public static final String TAG = BaseActivityWithDrawer.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(shouldEnableDrawer() ? R.layout.activity_base_with_drawer : R.layout.activity_base_without_drawer);

        contentFrame = (FrameLayout) findViewById(R.id.content_frame);
        Log.d(TAG, "drawer enabled: " + shouldEnableDrawer());

        leftDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set a Click Listener to the hamburger icon
        ImageButton btn_hamburger = (ImageButton) findViewById(R.id.hamburgerDrawer);
        btn_hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftDrawer.openDrawer(Gravity.LEFT);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);

       // set Color State correctly to avoid the blue
        int[][] state = new int[][] {
                new int[] { android.R.attr.state_enabled }, // enabled
                new int[] { android.R.attr.state_pressed },  // pressed
                new int[] { android.R.attr.state_last },  // pressed
                new int[] { android.R.attr.state_selected }  // pressed
        };
        int[] color = new int[] {
                Color.BLACK,
                Color.GRAY,
                Color.LTGRAY,
                Color.LTGRAY
        };

        ColorStateList colorStateList = new ColorStateList(state, color);
        navigationView.setItemTextColor(colorStateList);
    }


    @Override
    public void onBackPressed() {
        if (leftDrawer.isDrawerOpen(GravityCompat.START)) {
            leftDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navigation_item_1) {

            Intent intent = new Intent(getApplicationContext(), Info_Journey.class);
            intent.putExtra("firstCall", true);
            startActivity(intent);

        } else if (id == R.id.navigation_item_2) {

            Intent intent = new Intent(getApplicationContext(), Info_Mood.class);
            intent.putExtra("firstCall", true);
            startActivity(intent);

        } else if (id == R.id.navigation_item_3) {

            Intent intent = new Intent(getApplicationContext(), Info_Balancing.class);
            intent.putExtra("firstCall", true);
            startActivity(intent);

        } else if (id == R.id.navigation_item_4) {


            Intent intent = new Intent(getApplicationContext(), Info_Progress.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_5) {


            Intent intent = new Intent(getApplicationContext(), Info_Music.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_6) {

            Intent intent = new Intent(getApplicationContext(), Quote_day.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_7) {

            Intent intent = new Intent(getApplicationContext(), Terminology.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_8) {

            Intent intent = new Intent(getApplicationContext(), Notification.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_9) {

            Intent intent = new Intent(getApplicationContext(), About.class);
            startActivity(intent);

        }  else if (id == R.id.contactUs) {

            // implicit intent that sends an email with the standard email client of the user

            String[] addresses = {email};
            Intent intent = new Intent (Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Meditation Time App");
            intent.putExtra(Intent.EXTRA_TEXT, "Hi,");

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        leftDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        leftDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public abstract boolean shouldEnableDrawer();

    public ViewGroup getFrame() {
        return contentFrame;
    }


}
