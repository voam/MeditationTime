package com.meditation.metime.lib;

import com.meditation.metime.Mood_anxious;
import com.meditation.metime.R;

public class MoodData {

    public final static  int MOOD_ANGRY = 0;
    public final static int MOOD_ANXIOUS = 1;
    public static int MOOD_FEARFUL = 2;
    public static int MOOD_LONELY_SAD = 3;
    public static int MOOD_IMPATIENT = 4;
    public static int MOOD_LETHARGIC = 5;
    public static int MOOD_WORRIED = 6;
    public static int MOOD_DEPRESSED = 7;
    public static int MOOD_RESTLESS = 8;
    public static int MOOD_GUILTY = 9;
    public static int MOOD_NERVOUS = 10;
    public static int MOOD_STRESSED = 11;

    public static int DURATION_ANXIOUS_SECONDS = 229;

    public static MoodResource GetMoodResource(int moodKey) {

        MoodResource r = null;
        switch ( moodKey ) {

            case MOOD_ANXIOUS:

                return new MoodResource(R.color.mood_anxious,
                        R.string.mood_anxious,
                        "anxious.mp3",
                        Mood_anxious.class,
                        DURATION_ANXIOUS_SECONDS);

        }

        return r;
    }


}
/*
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
                }else if(selectedPosition ==1){
                    mood_type.setText("ANXIOUS");
                    //change the background color
                    mealLayout.setBackgroundColor(Color.parseColor("#CDE2B9"));
                    mood_type.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Mood_anxious.class);
                            startActivity(intent);
                        }
                    });
                    //choose fearful section
                }else if(selectedPosition ==2){
                    mood_type.setText("FEARFULL");
 */