/**
 *  MeDitationTime
 *
 *  Info_hand.class: Controller class for the info_hand section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class Info_hand extends AppCompatActivity {

    public static String STEP_KEY = "which_step";

    private int mStep = 1;
    private String TAG = getClass().getSimpleName();
    private Intent nextActivity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_hands);
        Intent callingIntent = getIntent();
        mStep = callingIntent.getIntExtra(STEP_KEY,0);

        RelativeLayoutButton hand_btn = new RelativeLayoutButton(this,R.id.hand_btn);
        //set text on button
        hand_btn.setText(R.id.button_text, "OK");

        if (mStep == 1) {
            nextActivity = new Intent(getApplicationContext(), Journey_level_1.class);
        }
        else {
            nextActivity = new Intent(getApplicationContext(), Journey_detail_audio.class);
            nextActivity.putExtra(STEP_KEY, mStep);
        }

        hand_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(nextActivity);

            }
        });




    }
}
