/**
 *  MeDitationTime
 *
 *  Music_darbari.class: Controller class for a media player of the music section
 *
 * WaveView: by john990 from https://github.com/john990/WaveView
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.android.vending.expansion.zipfile.APKExpansionSupport;
import com.android.vending.expansion.zipfile.ZipResourceFile;
import com.john.waveview.WaveView;

import org.meditatetoregenerate.metime.R;
import org.meditatetoregenerate.metime.utils.ExpansionUtils;

import java.io.IOException;
import java.io.InputStream;


public class Music_detail extends AppCompatActivity {

    public static String INTENT_SONG_INDEX = "songIndex";

    private String TAG = getClass().getSimpleName();
    private SeekBar seekBar;
    private WaveView waveView;
    private boolean isPaused = false;
    private long remaining=454000;
    private MediaPlayer Mp;
    private int songIndex = 0;

    private static int[] songDurations = {
            454, 560, 655,
            260, 641,880,
            473, 667, 603

    };
    private static String[] songs = {
            "darbari.mp3", "jaijaivanti.mp3", "freeforever.mp3",
            "hiddenwings.mp3", "highernature1.mp3", "highernature2.mp3",
            "innocenceandbeyond.mp3", "originaltruth1.mp3", "originaltruth2.mp3"

    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        Intent callingIntent = getIntent();
        songIndex = callingIntent.getIntExtra(INTENT_SONG_INDEX,0);
        remaining = songDurations[songIndex] * 1000;

        final ToggleButton play_btn = (ToggleButton) findViewById(R.id.p_p);
       // Mp= MediaPlayer.create(this, R.raw.darbari);
        waveView = (WaveView) findViewById(R.id.wave_view);

        String pathToFileInsideZip = songs[songIndex];
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
                            ExpansionUtils.MAIN_VERSION, 0);
            // Get an input stream for a known file inside the expansion file ZIPs
            //   fileStream = expansionFile.getInputStream(pathToFileInsideZip);

            //      ZipResourceFile.ZipEntryRO [] entries = expansionFile.getAllEntries();

            //this should never happen as expansion file is downloaded either a) when app is installed or b) when app starts
            //but it is useful in development stage when .obb expansion file may not be present or downloadable from Play store
            if (expansionFile == null) {

                Toast.makeText(this, R.string.play_file_error, Toast.LENGTH_LONG).show();
                //go back to wheel menu
                Intent intent = new Intent(getApplicationContext(), Music.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
                finish();
                return;
            }

            AssetFileDescriptor afd = expansionFile.getAssetFileDescriptor(pathToFileInsideZip);
            Mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            Mp.prepare();

        }
        catch(IOException ex) {

            Log.e(TAG, "Problem reading expansion file");
            ex.printStackTrace();

        }


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
                        int progress = (int)((songDurations[songIndex] - (millisUntilFinished / 1000))*(100/ (float) songDurations[songIndex] ));

                       // waveView.setProgress((int)((454-(millisUntilFinished / 1000))*(100/454.0)));

                        waveView.setProgress(progress);
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
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Mp.stop();
    }
}
