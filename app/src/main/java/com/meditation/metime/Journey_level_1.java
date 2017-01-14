/**
 *  MeDitationTime
 *
 *  Journey_level_1.class: Controller class for level one of the journey section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Journey_level_1 extends AppCompatActivity {

    //System stats
    private PrefManager prefManager;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        // record session data for progress evaluation
        prefManager = new PrefManager(this);
        prefManager.sessionStart();

        // create an object of media controller
        MediaController mediaController = new MediaController(this);

        VideoView level1_video = (VideoView)findViewById(R.id.video);
        level1_video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.one));

        level1_video.setMediaController(mediaController);

    }

    // save session data
    public void onStop(){
        super.onStop();
        prefManager = new PrefManager(this);
        prefManager.sessionEnd();
        prefManager.setUnlocked(1);
        prefManager.setUnlocked(2);
    }

}