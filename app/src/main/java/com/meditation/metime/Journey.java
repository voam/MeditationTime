package com.meditation.metime;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import static com.meditation.metime.R.id.information;
import static com.meditation.metime.R.id.level1;

public class Journey extends BaseActivityWithDrawer {

    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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


        //Journey Buttons

        ImageButton level_btn_1 = (ImageButton) findViewById(level1);
        level_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Level.class);
                startActivity(intent);
            }
        });
    }
}
