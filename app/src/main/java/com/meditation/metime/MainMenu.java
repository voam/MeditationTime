package com.meditation.metime;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.meditation.metime.R.id.Bala_btn;
import static com.meditation.metime.R.id.Journey_btn;
import static com.meditation.metime.R.id.Mood_btn;
import static com.meditation.metime.R.id.information;

public class MainMenu extends BaseActivityWithDrawer {


    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater.from(this).inflate(R.layout.activity_main_menu, getFrame());


        //navigate to journey section
        RelativeLayoutButton Jou_btn = new RelativeLayoutButton(this, R.id.Journey_btn);
        Jou_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Journey.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
            }
        });

        //navigate to mood section
        RelativeLayoutButton mo_btn = new RelativeLayoutButton(this, R.id.Mood_btn);
        mo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Mood.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
            }
        });

        //navigate to balancing section
        RelativeLayoutButton balancing_btn = new RelativeLayoutButton(this, R.id.Bala_btn);
        balancing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Balancing.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
            }
        });

        //navigate to info screen
        ImageButton info_btn = (ImageButton) findViewById(information);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Intro.class);
                intent.putExtra("infoBtn", true);
                startActivity(intent);
            }
        });
    }


}
