package com.meditation.metime;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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


    }
}
