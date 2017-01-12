package com.meditation.metime;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.graphics.BitmapFactory;

import static com.meditation.metime.R.id.information;

public class MainMenu extends BaseActivityWithDrawer {

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

        LayoutInflater.from(this).inflate(R.layout.activity_main_menu, getFrame());


        // journey button
        RelativeLayoutButton Jou_btn = new RelativeLayoutButton(this, R.id.Journey_btn);
        Jou_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Journey.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
            }
        });

        // mood button
        RelativeLayoutButton mo_btn = new RelativeLayoutButton(this, R.id.Mood_btn);
        // lock button if intro meditation has not been completed
        if(prefManager.isLocked(1)) {
            mo_btn.setEnabled(false);
            mo_btn.setImageResource(R.id.button_image, R.drawable.mood_icon_lightblue);
            mo_btn.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_intro));
        }
        mo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Mood.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
            }
        });

        // balancing button
        RelativeLayoutButton balancing_btn = new RelativeLayoutButton(this, R.id.Bala_btn);
        // lock button if intro meditation has not been completed
        if(prefManager.isLocked(1)) {
            balancing_btn.setEnabled(false);
            balancing_btn.setImageResource(R.id.button_image, R.drawable.balancing_icon_lightblue);
            balancing_btn.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_intro));
        }
        balancing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Balancing.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
            }
        });

        // info button
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
