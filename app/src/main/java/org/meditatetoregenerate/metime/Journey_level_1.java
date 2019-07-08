/**
 *  MeDitationTime
 *
 *  Journey_level_1.class: Controller class for level one of the journey section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import org.meditatetoregenerate.metime.R;

import org.meditatetoregenerate.metime.providers.VideoZipProvider;

public class Journey_level_1 extends AppCompatActivity {

    //System stats
    private PrefManager prefManager;
    private AlertDialog.Builder builder;
    private String TAG = getClass().getSimpleName();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        // record session data for progress evaluation
        prefManager = new PrefManager(this);
        prefManager.sessionStart();

        builder = new AlertDialog.Builder(this);

        // create an object of media controller
        MediaController mediaController = new MediaController(this);

        VideoView level1_video = (VideoView)findViewById(R.id.video);
       // Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.one);
        String fileName = "one.mp4";
        Uri videoUri = VideoZipProvider.buildUri(fileName);
        Log.i(TAG, "videoUri: " + videoUri.toString());
        level1_video.setVideoURI(videoUri);

        level1_video.setMediaController(mediaController);
        level1_video.start();

        level1_video.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mp)
            {
                builder.setMessage("Would you like to rate your progress?").
                        setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getApplicationContext(), Info_Progress.class);
                        intent.putExtra("firstCall", true);
                        startActivity(intent);
                    }
                }).setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });

                // display the dialog
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

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