/**
 *  MeDitationTime
 *
 *  Journey_level_2.class: Controller class for level two of the journey section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.john.waveview.WaveView;


public class Journey_level_2 extends AppCompatActivity {

    // system stats
    private PrefManager prefManager;

    // status visualization
    private WaveView waveView;

    // audio player
    private boolean isPaused = false;
    private long remaining = 254000; // total duration in milliseconds
    private MediaPlayer Mp;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        // record session data for progress evaluation
        prefManager = new PrefManager(this);
        prefManager.sessionStart();

        final ToggleButton play_btn = (ToggleButton) findViewById(R.id.p_p);

        Mp = MediaPlayer.create(this, R.raw.two);


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
                        waveView.setProgress((int)((254-(millisUntilFinished / 1000))*(100/254.0)));
                        remaining = millisUntilFinished;

                        if(remaining<2000){
                            finish();
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
        prefManager.setUnlocked(3);
    }

    public void onBackPressed(){
        super.onBackPressed();
        Mp.stop();
    }
}