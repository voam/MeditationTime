/**
 *  MeDitationTime
 *
 *  Journey.class: Controller class for the journey section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import org.meditatetoregenerate.metime.R;

import static org.meditatetoregenerate.metime.R.id.information;

public class Journey extends BaseActivityWithDrawer {

    // Locking status
    private PrefManager prefManager;

    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);

       // sets the journey layout to the BaseActivityWithDrawer
        LayoutInflater.from(this).inflate(R.layout.activity_journey, getFrame());

        //App Buttons

        ImageButton info_btn = (ImageButton) findViewById(information);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Journey.class);
                startActivity(intent);
            }
        });

        final Intent intentHand = new Intent(getApplicationContext(), Info_hand.class);
        //Journey Buttons

        RelativeLayoutButton level_btn_1 = new RelativeLayoutButton(this,R.id.level1);
        level_btn_1.setText(R.id.button_text, "1");
        //ImageButton level_btn_1 = (ImageButton) findViewById(level1);
        level_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //    Intent intent = new Intent(getApplicationContext(), Info_hand_1.class);
                intentHand.putExtra(Info_hand.STEP_KEY, 1);
                startActivity(intentHand);
            }
        });

        RelativeLayoutButton level_btn_2 = new RelativeLayoutButton(this,R.id.level2);
        level_btn_2.setText(R.id.button_text, "2");
        //ImageButton level_btn_2 = (ImageButton) findViewById(R.id.Journey_level_2);
        level_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Intent intent = new Intent(getApplicationContext(), Info_hand_2.class);
                intentHand.putExtra(Info_hand.STEP_KEY, 2);
                startActivity(intentHand);
            }
        });
        // lock button if previous stage has not yet been completed
        if(prefManager.isLocked(2)) {
            level_btn_2.setEnabled(false);
            level_btn_2.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_journey));
        }

        RelativeLayoutButton level_btn_3 = new RelativeLayoutButton(this,R.id.level3);
        level_btn_3.setText(R.id.button_text, "3");
        //ImageButton level_btn_3 = (ImageButton) findViewById(R.id.Journey_level_3);
        level_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent = new Intent(getApplicationContext(), Info_hand_3.class);
                intentHand.putExtra(Info_hand.STEP_KEY, 3);
                startActivity(intentHand);
             //   startActivity(intent);
            }
        });
        // lock button if previous stage has not yet been completed
        if(prefManager.isLocked(3)) {
            level_btn_3.setEnabled(false);
            level_btn_3.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_journey));
        }

        RelativeLayoutButton level_btn_4 = new RelativeLayoutButton(this,R.id.level4);
        level_btn_4.setText(R.id.button_text, "4");
        //ImageButton level_btn_4 = (ImageButton) findViewById(R.id.Journey_level_4);
        level_btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent = new Intent(getApplicationContext(), Info_hand_4.class);
                intentHand.putExtra(Info_hand.STEP_KEY, 4);
                startActivity(intentHand);
               // startActivity(intent);
            }
        });
        // lock button if previous stage has not yet been completed
        if(prefManager.isLocked(4)) {
            level_btn_4.setEnabled(false);
            level_btn_4.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_journey));
        }

        RelativeLayoutButton level_btn_5 = new RelativeLayoutButton(this,R.id.level5);
        level_btn_5.setText(R.id.button_text, "5");
        //ImageButton level_btn_5 = (ImageButton) findViewById(R.id.Journey_level_5);
        level_btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent = new Intent(getApplicationContext(), Info_hand_5.class);
                intentHand.putExtra(Info_hand.STEP_KEY, 5);
                startActivity(intentHand);
                //startActivity(intent);
            }
        });
        // lock button if previous stage has not yet been completed
        if(prefManager.isLocked(5)) {
            level_btn_5.setEnabled(false);
            level_btn_5.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_journey));
        }

        RelativeLayoutButton level_btn_6 = new RelativeLayoutButton(this,R.id.level6);
        level_btn_6.setText(R.id.button_text, "6");
        //ImageButton level_btn_6 = (ImageButton) findViewById(R.id.Journey_level_6);
        level_btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(getApplicationContext(), Info_hand_6.class);
                intentHand.putExtra(Info_hand.STEP_KEY, 6);
                startActivity(intentHand);
             //   startActivity(intent);
            }
        });
        // lock button if previous stage has not yet been completed
        if(prefManager.isLocked(6)) {
            level_btn_6.setEnabled(false);
            level_btn_6.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_journey));
        }

        RelativeLayoutButton level_btn_7 = new RelativeLayoutButton(this,R.id.level7);
        level_btn_7.setText(R.id.button_text, "7");
        //ImageButton level_btn_7 = (ImageButton) findViewById(R.id.Journey_level_7);
        level_btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent = new Intent(getApplicationContext(), Info_hand_7.class);
                intentHand.putExtra(Info_hand.STEP_KEY, 7);
                startActivity(intentHand);
              //  startActivity(intent);
            }
        });
        // lock button if previous stage has not yet been completed
        if(prefManager.isLocked(7)) {
            level_btn_7.setEnabled(false);
            level_btn_7.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_journey));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        prefManager = new PrefManager(this);
        Log.d("onStart", "onStart invoked");

        RelativeLayoutButton level_btn_2 = new RelativeLayoutButton(this,R.id.level2);
        RelativeLayoutButton level_btn_3 = new RelativeLayoutButton(this,R.id.level3);
        RelativeLayoutButton level_btn_4 = new RelativeLayoutButton(this,R.id.level4);
        RelativeLayoutButton level_btn_5 = new RelativeLayoutButton(this,R.id.level5);
        RelativeLayoutButton level_btn_6 = new RelativeLayoutButton(this,R.id.level6);
        RelativeLayoutButton level_btn_7 = new RelativeLayoutButton(this,R.id.level7);

        // check if respective meditation has been done and enable next session if so
        if(!prefManager.isLocked(2)) {
            // re-enable button
            level_btn_2.setEnabled(true);
            level_btn_2.setTextColor(R.id.button_text, Color.WHITE);
            level_btn_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Info_hand.class);
                    intent.putExtra(Info_hand.STEP_KEY,2);
                    startActivity(intent);
                }
            });
        }

        if(!prefManager.isLocked(3)) {
            // re-enable button
            level_btn_3.setEnabled(true);
            level_btn_3.setTextColor(R.id.button_text, Color.WHITE);
            level_btn_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Info_hand.class);
                    intent.putExtra(Info_hand.STEP_KEY,3);
                    startActivity(intent);
                }
            });
        }

        if(!prefManager.isLocked(4)) {
            // re-enable button
            level_btn_4.setEnabled(true);
            level_btn_4.setTextColor(R.id.button_text, Color.WHITE);
            level_btn_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Info_hand.class);
                    intent.putExtra(Info_hand.STEP_KEY,4);
                    startActivity(intent);
                }
            });
        }

        if(!prefManager.isLocked(5)) {
            // re-enable button
            level_btn_5.setEnabled(true);
            level_btn_5.setTextColor(R.id.button_text, Color.WHITE);
            level_btn_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Info_hand.class);
                    intent.putExtra(Info_hand.STEP_KEY,5);
                    startActivity(intent);
                }
            });
        }

        if(!prefManager.isLocked(6)) {
            // re-enable button
            level_btn_6.setEnabled(true);
            level_btn_6.setTextColor(R.id.button_text, Color.WHITE);
            level_btn_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Info_hand.class);
                    intent.putExtra(Info_hand.STEP_KEY,6);
                    startActivity(intent);
                }
            });
        }

        if(!prefManager.isLocked(7)) {
            // re-enable button
            level_btn_7.setEnabled(true);
            level_btn_7.setTextColor(R.id.button_text, Color.WHITE);
            level_btn_7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Info_hand.class);
                    intent.putExtra(Info_hand.STEP_KEY,7);
                    startActivity(intent);
                }
            });
        }
    }
}
