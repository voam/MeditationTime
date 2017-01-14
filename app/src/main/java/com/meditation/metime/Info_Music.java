/**
 *  MeDitationTime
 *
 *  Info_Music.class: Controller class for the music info section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Info_Music extends AppCompatActivity {

    private Button btnStart;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch("Music")) {
            launchNextScreen();
            finish();
        }

        setContentView(R.layout.activity_music_info);

        btnStart = (Button) findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextScreen();
            }
        });

    }

    private void launchNextScreen() {
        prefManager.setFirstTimeLaunch("Music", false);
        startActivity(new Intent(Info_Music.this, Music.class));
        finish();
    }

}