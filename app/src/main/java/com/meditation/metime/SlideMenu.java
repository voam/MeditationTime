package com.meditation.metime;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import static com.meditation.metime.R.id.Bala_btn;
import static com.meditation.metime.R.id.Journey_btn;
import static com.meditation.metime.R.id.Mood_btn;

public class SlideMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    // constant that goes to an email address

    private static String email = "johannes@dr-landgraf.de";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_slide_menu);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ImageButton btn_hamburger = (ImageButton) findViewById(R.id.hamburger);
        btn_hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //navigate to journey section
        Button Jou_btn = (Button) findViewById(Journey_btn);
        Jou_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), JourneyInfoActivity.class);
                startActivity(intent);
            }
        });

        //navigate to mood section
        Button mo_btn = (Button) findViewById(Mood_btn);
        mo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Mood.class);
                startActivity(intent);
            }
        });

        //navigate to mood section
        Button balancing_btn = (Button) findViewById(Bala_btn);
        balancing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Balancing.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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

            Intent intent = new Intent(getApplicationContext(), JourneyInfoActivity.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_2) {

            Intent intent = new Intent(getApplicationContext(), Mood.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_3) {

            Intent intent = new Intent(getApplicationContext(), Balancing.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_4) {


            Intent intent = new Intent(getApplicationContext(), Progress.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_5) {


            Intent intent = new Intent(getApplicationContext(), Music.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_6) {

            Intent intent = new Intent(getApplicationContext(), Quote_day.class);
            startActivity(intent);

        } else if (id == R.id.navigation_item_7) {

            // has to be defined
            //   Intent intent = new Intent(getApplicationContext(), Balancing.class);
            //    startActivity(intent);

        } else if (id == R.id.navigation_item_8) {

            // has to be defined
            //   Intent intent = new Intent(getApplicationContext(), Balancing.class);
            //    startActivity(intent);

        } else if (id == R.id.navigation_item_9) {

            // has to be defined
            //   Intent intent = new Intent(getApplicationContext(), Balancing.class);
            //    startActivity(intent);

        }  else if (id == R.id.contactUs) {

            // implicit intent that sends an email with the standard email client of the user

            String[] addresses = {email};
            Intent intent = new Intent (Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Contact request");
            intent.putExtra(Intent.EXTRA_TEXT, "Hi,");

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
