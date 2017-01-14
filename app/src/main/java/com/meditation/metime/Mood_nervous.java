/**
 *  MeDitationTime
 *
 *  Mood_nervous.class: Controller class for a specific mood of the mood section
 *
 *  com.john.waveview.WaveView: by john990 from https://github.com/john990/WaveView
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.john.waveview.WaveView;


public class Mood_nervous extends AppCompatActivity {

    //System stats
    private PrefManager prefManager;

    // status visualization
    private WaveView waveView;

    // audio player
    private boolean isPaused = false;
    private long remaining=173000;
    private MediaPlayer Mp;
    private AlertDialog.Builder builder;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_nervous);

        // instantiate a new alert dialog builder
        builder = new AlertDialog.Builder(this);

        // record session data for progress evaluation
        prefManager = new PrefManager(this);
        prefManager.sessionStart();

        final ToggleButton play_btn = (ToggleButton) findViewById(R.id.p_p);
        Mp= MediaPlayer.create(this, R.raw.nerviousness);
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
                        waveView.setProgress((int)((173-(millisUntilFinished / 1000))*(100/173.0)));
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
