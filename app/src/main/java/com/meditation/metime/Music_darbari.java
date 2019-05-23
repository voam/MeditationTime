/**
 *  MeDitationTime
 *
 *  Music_darbari.class: Controller class for a media player of the music section
 *
 * com.john.waveview.WaveView: by john990 from https://github.com/john990/WaveView
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.john.waveview.WaveView;


public class Music_darbari extends AppCompatActivity {

    private SeekBar seekBar;
    private WaveView waveView;
    private boolean isPaused = false;
    private long remaining=454000;
    private MediaPlayer Mp;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_darbari);

        final ToggleButton play_btn = (ToggleButton) findViewById(R.id.p_p);
        Mp= MediaPlayer.create(this, R.raw.darbari);
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
                        //set the level of waveview
                        waveView.setProgress((int)((454-(millisUntilFinished / 1000))*(100/454.0)));
                        remaining = millisUntilFinished;
                        //finish activity if timer approach 2s
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

    //stop the media id back button is pressed
    public void onBackPressed(){
        super.onBackPressed();
        Mp.stop();
    }
}
