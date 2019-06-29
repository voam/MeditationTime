/**
 *  MeDitationTime
 *
 *  Info_Music.class: Controller class for the music info section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import org.meditatetoregenerate.metime.R;

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