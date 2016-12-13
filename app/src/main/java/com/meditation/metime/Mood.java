package com.meditation.metime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.anupcowkur.wheelmenu.WheelMenu;

import static com.meditation.metime.R.id.information;

public class Mood extends AppCompatActivity {

    private WheelMenu wheelMenu;
    private TextView selectedPositionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);


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


        wheelMenu.setDivCount(12);

        wheelMenu.setWheelImage(R.drawable.mood);

//        selectedPositionText = (TextView) findViewById(R.id.selected_position_text);
//        selectedPositionText.setText("selected: " + (wheelMenu.getSelectedPosition() + 1));

        wheelMenu.setWheelChangeListener(new WheelMenu.WheelChangeListener() {
            @Override
            public void onSelectionChange(int selectedPosition) {
//                selectedPositionText.setText("selected: " + (selectedPosition + 1));
                if(selectedPosition ==1){
                    mood_type.setText("FEARFULL");
                }else if(selectedPosition ==2){
                    mood_type.setText("LONELY/SAD");
                }else if(selectedPosition ==3){
                    mood_type.setText("IMPATIENT");
                }else if(selectedPosition ==4){
                    mood_type.setText("LETHARGIC");
                }else if(selectedPosition ==5){
                    mood_type.setText("WORRIED");
                }else if(selectedPosition ==6){
                    mood_type.setText("DEPRESSED");
                }else if(selectedPosition ==7){
                    mood_type.setText("RESTLESS");
                }else if(selectedPosition ==8){
                    mood_type.setText("GUILTY");
                }else if(selectedPosition ==9){
                    mood_type.setText("NERVOUS");
                }else if(selectedPosition ==10){
                    mood_type.setText("STRESSED");
                }else if(selectedPosition ==11){
                    mood_type.setText("ANGRY");
                }else if(selectedPosition ==12){
                    mood_type.setText("ANXIOUS");
                }
            }
        });


    }
}