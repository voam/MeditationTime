/**
 *  MeDitationTime
 *
 *  SplashScreen.class: Controller class for the splash screen
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.meditation.metime.utils.ExpansionUtils;

public class SplashScreen extends AppCompatActivity {

        private String TAG = getClass().getSimpleName();
        // SplashScreen screen timer
        //private static int SPLASH_TIME_OUT = 3000;
        private static int SPLASH_TIME_OUT = 100;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);


            Boolean bObbExists = ExpansionUtils.ExpansionFilesExist(this);

            Log.i(TAG, "Obb Exists: " + bObbExists);

            new Handler().postDelayed(new Runnable() {

            /*
             * Showing SplashScreen screen for 3000 milils
             *
             */

                @Override
                public void run() {
                   //intent to mainmenu directly after SplashScreen timer is over.
                    Intent i = new Intent(SplashScreen.this, Info_Intro.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }

    }