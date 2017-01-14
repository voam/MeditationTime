package com.meditation.metime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class splash extends AppCompatActivity {

        // Splash screen timer
        private static int SPLASH_TIME_OUT = 3000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen for 3000 milils
             *
             */

                @Override
                public void run() {
                   //intent to mainmenu directly after splash timer is over.
                    Intent i = new Intent(splash.this, Info_Intro.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }

    }