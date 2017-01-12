package com.meditation.metime;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.meditation.metime.R.id.information;

public class Balancing extends BaseActivityWithDrawer {

    // enables drawer

    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the balancing layout to the BaseActivityWithDrawer

        LayoutInflater.from(this).inflate(R.layout.activity_balancing, getFrame());


        //App Buttons
        ImageButton info_btn = (ImageButton) findViewById(information);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Balancing.class);
                startActivity(intent);
            }
        });

        //Element Buttons
        //Water
        RelativeLayoutButton water_btn = new RelativeLayoutButton(this,R.id.Water_btn);
        water_btn.setText(R.id.button_text, "Water");
        water_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), water.class);
                startActivity(intent);
            }
        });

        //Fire
        RelativeLayoutButton fire_btn = new RelativeLayoutButton(this,R.id.Fire_btn);
        fire_btn.setText(R.id.button_text, "Fire");
        fire_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), fire.class);
                startActivity(intent);
            }
        });

        //Air
        RelativeLayoutButton air_btn = new RelativeLayoutButton(this,R.id.Air_btn);
        air_btn.setText(R.id.button_text, "Air/Ether");
        air_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), air.class);
                startActivity(intent);
            }
        });

        //Earth
        RelativeLayoutButton earth_btn = new RelativeLayoutButton(this,R.id.Earth_btn);
        earth_btn.setText(R.id.button_text, "Earth");
        earth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), earth.class);
                startActivity(intent);
            }
        });

    }
}
