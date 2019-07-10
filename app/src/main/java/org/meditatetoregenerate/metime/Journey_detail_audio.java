/**
 *  MeDitationTime
 *
 *  Journey_detail_audio.class: Controller class for levels 2-7 of the journey section
 *
 *  WaveView: by john990 from https://github.com/john990/WaveView
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.vending.expansion.zipfile.APKExpansionSupport;
import com.android.vending.expansion.zipfile.ZipResourceFile;
//import com.john.waveview.WaveView;
import net.rallaesystems.waveview.WaveView;

import org.meditatetoregenerate.metime.R;
import org.meditatetoregenerate.metime.utils.ExpansionUtils;

import java.io.IOException;
import java.io.InputStream;


public class Journey_detail_audio extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();
    // system stats
    private PrefManager prefManager;

    // status visualization
    private WaveView waveView;

    // audio player
    private boolean isPaused = false;
    private long remaining = 254000; // total duration in milliseconds
    private MediaPlayer Mp;
    private AlertDialog.Builder builder;

    private int mStep = 2;

    //index is mStep - 1, step 1 is video so is not here
    // the length, in seconds on the audio files
    private int[] playTimeSeconds = {0, 254, 89, 200, 148, 202, 198 };

    // the names of the audio files in the expansion file
    private String[] playFiles = {"", "two.mp3", "three.mp3", "four.mp3", "five.mp3", "six.mp3", "seven.mp3" };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_level_detail);
        Intent callingIntent = getIntent();
        mStep = callingIntent.getIntExtra(Info_hand.STEP_KEY  ,2);

        Log.i(TAG, String.format("Step = %d", mStep));

        // instantiate a new alert dialog builder
        builder = new AlertDialog.Builder(this);

        // record session data for progress evaluation
        prefManager = new PrefManager(this);
        prefManager.sessionStart();

        final ToggleButton play_btn = (ToggleButton) findViewById(R.id.p_p);

        //Mp = MediaPlayer.create(this, R.raw.two);
        //begin

        String pathToFileInsideZip = playFiles[mStep -1];
        remaining = playTimeSeconds[mStep -1] * 1000;
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
                Intent intent = new Intent(getApplicationContext(), Info_Journey.class);
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

        //end


        waveView = (WaveView) findViewById(R.id.wave_view);
        waveView.setMaxValue(playTimeSeconds[mStep -1]);

        play_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if(play_btn.isChecked()){
                    isPaused=false;
                }else{
                    isPaused=true;
                }

                //the length of music
                long mills = remaining;
                //controller of media player
                if(!isPaused){
                    Mp.start();
                }else{
                    Mp.pause();
                }

                new CountDownTimer(remaining, 50) { // adjust the milli seconds here

                    public void onTick(long millisUntilFinished) {

                        if(isPaused){
                            cancel();
                        }

                       // int progress = (int)((playTimeSeconds[mStep -1] - (millisUntilFinished / 1000))*(100/ (float) playTimeSeconds[mStep -1] ));

                        //   Log.i(TAG, String.format("Progress: ", progress));

                        float progress = playTimeSeconds[mStep -1] - (millisUntilFinished / 1000f);
                        waveView.setCurrentValue(progress);

                    //    waveView.setProgress((int)((254-(millisUntilFinished / 1000))*(100/254.0)));
                        remaining = millisUntilFinished;

                        // display message dialog if audio file has finished
                        if(remaining<2000){
                            // setup new dialog content
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
                    }

                    public void onFinish() {

                    }
                }.start();


            }
        });



    }

    // save session data
    @Override
    public void onStop(){
        super.onStop();
        prefManager = new PrefManager(this);
        prefManager.sessionEnd();
        //unlock next step if not on final step
        if (mStep < 7) {
            prefManager.setUnlocked(mStep + 1);
        }

    }

    //stop media if back button is pressed
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Mp.stop();
    }
}
