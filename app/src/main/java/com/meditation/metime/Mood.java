/**
 *  MeDitationTime
 *
 *  Mood.class: Controller class for the mood section
 *
 *  com.anupcowkur.wheelmenu.WheelMenu: by anupcowkur from https://github.com/anupcowkur/Android-Wheel-Menu
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.anupcowkur.wheelmenu.WheelMenu;
import com.meditation.metime.lib.MoodData;
import com.meditation.metime.lib.MoodResource;

import static com.meditation.metime.R.id.information;

public class Mood extends BaseActivityWithDrawer {

    private WheelMenu wheelMenu;
    private TextView selectedPositionText;
    private RelativeLayout mealLayout;


    // enables the drawer view
    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the journey layout to the BaseActivityWithDrawer
        LayoutInflater.from(this).inflate(R.layout.activity_mood, getFrame());

        mealLayout=(RelativeLayout) findViewById(R.id.activity_mood);



        //App Buttons
        ImageButton info_btn = (ImageButton) findViewById(information);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Mood.class);
                startActivity(intent);
            }
        });


        //Mood Wheel
        wheelMenu = (WheelMenu) findViewById(R.id.wheelMenu);

        final Button mood_type = (Button) findViewById(R.id.mood_type);

        //divides the mood wheel to 12 sections
        wheelMenu.setDivCount(12);

        wheelMenu.setWheelImage(R.drawable.mood_wheel);


        wheelMenu.setWheelChangeListener(new WheelMenu.WheelChangeListener() {
            @Override
            public void onSelectionChange(final int selectedPosition) {
                //choose sad section
                final MoodResource r = MoodData.GetMoodResource(selectedPosition);
                if (r != null) {
                    mood_type.setText(r.getTextResource());
                    mealLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), r.getColorResource()));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), r.getClassName());
                            intent.putExtra(Mood_detail.INTENT_KEY_MOOD, selectedPosition);
                            startActivity(intent);
                        }
                    });
                }

                if(selectedPosition ==3){
                    mood_type.setText("LONELY/SAD");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#BBDFCE"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_sad.class);
                            startActivity(intent);
                        }
                    });

                    //choose impatient section
                }else if(selectedPosition ==4){
                    mood_type.setText("IMPATIENT");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#BBE1E3"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_impatient.class);
                            startActivity(intent);
                        }
                    });
                    //choose lethargic section
                }else if(selectedPosition ==5){
                    mood_type.setText("LETHARGIC");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#B7E1F2"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_lethargic.class);
                            startActivity(intent);
                        }
                    });
                    //choose worried section
                }else if(selectedPosition ==6){
                    mood_type.setText("WORRIED");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#B9C7E3"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_worried.class);
                            startActivity(intent);
                        }
                    });
                    //choose depressed section
                }else if(selectedPosition ==7){
                    mood_type.setText("DEPRESSED");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#C2B8D8"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_depressed.class);
                            startActivity(intent);
                        }
                    });
                    //choose restless section
                }else if(selectedPosition ==8){
                    mood_type.setText("RESTLESS");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#D3B8D7"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_restless.class);
                            startActivity(intent);
                        }
                    });
                    //choose guilty section
                }else if(selectedPosition ==9){
                    mood_type.setText("GUILTY");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#FBD3D2"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_guilty.class);
                            startActivity(intent);
                        }
                    });
                    //choose nervous section
                }else if(selectedPosition ==10){
                    mood_type.setText("NERVOUS");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#FEE5D5"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_nervous.class);
                            startActivity(intent);
                        }
                    });
                    //choose stressed section
                }else if(selectedPosition ==11){
                    mood_type.setText("STRESSED");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#F3EABE"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_stressed.class);
                            startActivity(intent);
                        }
                    });
                    //choose angry section
                }else if(selectedPosition ==0){
                    mood_type.setText("ANGRY");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#E5EBBE"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_angry.class);
                            startActivity(intent);
                        }
                    });
                    //choose anxious section
//                }else if(selectedPosition ==1){
//                    mood_type.setText("ANXIOUS");
//                    //change the background color
//                    mealLayout.setBackgroundColor(Color.parseColor("#CDE2B9"));
//                    mood_type.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                            Intent intent = new Intent(getApplicationContext(), Mood_anxious.class);
//                            startActivity(intent);
//                        }
//                    });
                    //choose fearful section
                }else if(selectedPosition ==2){
                    mood_type.setText("FEARFULL");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#B9DAB9"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_fearful.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });


    }
}