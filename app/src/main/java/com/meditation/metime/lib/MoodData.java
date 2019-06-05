package com.meditation.metime.lib;

import com.meditation.metime.Mood_anxious;
import com.meditation.metime.Mood_detail;
import com.meditation.metime.R;

public class MoodData {

    public final static  int MOOD_ANGRY = 0;
    public final static int MOOD_ANXIOUS = 1;
    public final static int MOOD_FEARFUL = 2;
    public final static int MOOD_LONELY_SAD = 3;
    public final static int MOOD_IMPATIENT = 4;
    public final static int MOOD_LETHARGIC = 5;
    public final static int MOOD_WORRIED = 6;
    public final static int MOOD_DEPRESSED = 7;
    public final static int MOOD_RESTLESS = 8;
    public final static int MOOD_GUILTY = 9;
    public final static int MOOD_NERVOUS = 10;
    public final static int MOOD_STRESSED = 11;

    public static int DURATION_ANXIOUS_SECONDS = 229;
    public static int DURATION_LONEY_SAY_SECONDS = 265;
    public static int DURATION_IMPATIENT_SECONDS = 230;
    public static int DURATION_LETHARGIC_SECONDS = 179;
    public static int DURATION_WORRIED_SECONDS = 194;
    public static int DURATION_DEPRESSED_SECONDS = 250;
    public static int DURATION_RESTLESS_SECONDS = 194;
    public static int DURATION_GUILTY_SECONDS = 209;
    public static int DURATION_NERVOUS_SECONDS = 173;
    public static int DURATION_STRESSED_SECONDS = 301;
    public static int DURATION_ANGRY_SECONDS = 270;
    public static int DURATION_FEARFUL_SECONDS = 148;

    public static MoodResource GetMoodResource(int moodKey) {

        MoodResource r = null;
        switch ( moodKey ) {

            case MOOD_ANXIOUS:

                return new MoodResource(R.color.mood_anxious,
                        R.string.mood_anxious,
                        "anxiety.mp3",
                        DURATION_ANXIOUS_SECONDS);

            case MOOD_LONELY_SAD:
                return new MoodResource(R.color.mood_lonely_sad,
                        R.string.mood_lonely_sad,
                        "sadness.mp3",
                        DURATION_LONEY_SAY_SECONDS);

            case MOOD_IMPATIENT:
                return new MoodResource(R.color.mood_impatient,
                        R.string.mood_impatient,
                        "impatients.mp3",
                        DURATION_IMPATIENT_SECONDS);

            case MOOD_LETHARGIC:
                return new MoodResource(R.color.mood_lethargic,
                        R.string.mood_lethargic,
                        "laziness.mp3",
                        DURATION_LETHARGIC_SECONDS);

            case MOOD_WORRIED:
                return new MoodResource(R.color.mood_worried,
                        R.string.mood_worried,
                        "worried.mp3",
                        DURATION_WORRIED_SECONDS);

            case MOOD_DEPRESSED:
                return new MoodResource(R.color.mood_depressed,
                        R.string.mood_depressed,
                        "depression.mp3",
                        DURATION_DEPRESSED_SECONDS);

            case MOOD_RESTLESS:
                return new MoodResource(R.color.mood_restless,
                        R.string.mood_restless,
                        "restlessness.mp3",
                        DURATION_RESTLESS_SECONDS);

            case MOOD_GUILTY:
                return new MoodResource(R.color.mood_guilty,
                        R.string.mood_guilty,
                        "guilt.mp3",
                        DURATION_GUILTY_SECONDS);

            case MOOD_NERVOUS:
                return new MoodResource(R.color.mood_nervous,
                        R.string.mood_nervous,
                        "nerviousness.mp3",
                        DURATION_NERVOUS_SECONDS);

            case MOOD_STRESSED:
                return new MoodResource(R.color.mood_stressed,
                        R.string.mood_stressed,
                        "stress.mp3",
                        DURATION_STRESSED_SECONDS);

            case MOOD_ANGRY:
                return new MoodResource(R.color.mood_angry,
                        R.string.mood_angry,
                        "anger.mp3",
                        DURATION_ANGRY_SECONDS);

            case MOOD_FEARFUL:
                return new MoodResource(R.color.mood_fearful,
                        R.string.mood_fearful,
                        "fear.mp3",
                        DURATION_FEARFUL_SECONDS);



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