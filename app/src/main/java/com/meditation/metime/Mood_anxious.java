/**
 *  MeDitationTime
 *
 *  Mood_lethargic.class: Controller class for a specific mood of the mood section
 *
 *  com.john.waveview.WaveView: by john990 from https://github.com/john990/WaveView
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import com.android.vending.expansion.zipfile.APKExpansionSupport;
import com.android.vending.expansion.zipfile.ZipResourceFile;
import com.john.waveview.WaveView;

import java.io.IOException;
import java.io.InputStream;


public class Mood_anxious extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();
    // system stats
    private PrefManager prefManager;

    // status visualization
    private WaveView waveView;

    // audio player
    private boolean isPaused = false;
    private long remaining = 229000;
    private MediaPlayer Mp;
    private AlertDialog.Builder builder;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_anxious);

        // instantiate a new alert dialog builder
        builder = new AlertDialog.Builder(this);

        // record session data for progress evaluation
        prefManager = new PrefManager(this);
        prefManager.sessionStart();

        final ToggleButton play_btn = (ToggleButton) findViewById(R.id.p_p);
       // Mp = MediaPlayer.create(this, R.raw.anxiety);

        //begin

        String pathToFileInsideZip = "anxiety.mp3";
        // Get a ZipResourceFile representing a specific expansion file

//        String fileName = String.format("main.%d.%s.obb", 1, getPackageName());
//        //         main.314159.com.example.app.obb
//        String filePathToMyZip = this.getObbDir().toString() + fileName;

        ZipResourceFile expansionFile = null;
        InputStream fileStream = null;
        Mp = new MediaPlayer();
        // Get a ZipResourceFile representing a merger of both the main and patch files
        try {
            expansionFile =
                    APKExpansionSupport.getAPKExpansionZipFile(
                            getApplicationContext(),
                            1, 0);
            // Get an input stream for a known file inside the expansion file ZIPs
         //   fileStream = expansionFile.getInputStream(pathToFileInsideZip);

         //   ZipResourceFile.ZipEntryRO [] entries = expansionFile.getAllEntries();


            AssetFileDescriptor afd = expansionFile.getAssetFileDescriptor(pathToFileInsideZip);

            Mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            Mp.prepare();

          //  fileStream.

         //   Log.i(TAG, "Success opening expansion file!" + fileStream.toString());

          //  fileStream.close();

        }
        catch(IOException ex) {

            Log.e(TAG, "Problem reading expansion file");
            ex.printStackTrace();

        }

        //end

        waveView = (WaveView) findViewById(R.id.wave_view);

        play_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(play_btn.isChecked()){
                    isPaused=false;
                }else{
                    isPaused=true;
                }

                //the length of music
                long mills = remaining;
                //control of media
                if(!isPaused){
                    Mp.start();
                }else{
                    Mp.pause();
                }

                new CountDownTimer(remaining, 1000) { // adjust the milli seconds here

                    public void onTick(long millisUntilFinished) {

                        if(isPaused){
                            cancel();
                        }
                        //set level of waveview
                        waveView.setProgress((int)((229-(millisUntilFinished / 1000))*(100/229.0)));
                        remaining = millisUntilFinished;

                        // display message dialog if audio file has finished
                        if(remaining<2000){
                            // setup new dialog content
                            builder.setMessage("Would you like to rate your progress?").
                                    setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(getApplicationContext(), Info_Progress.class);
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
                    }

                    public void onFinish() {

                    }
                }.start();


            }
        });



    }

    // save session data
    public void onStop(){
        super.onStop();
        prefManager = new PrefManager(this);
        prefManager.sessionEnd();
    }

    // stop the mediaplayer if the back button is pressed
    public void onBackPressed(){
        super.onBackPressed();
        Mp.stop();
    }
}
