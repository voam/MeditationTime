package com.meditation.metime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.meditation.metime.R.id.Journey_btn;
import static com.meditation.metime.R.id.information;
import static com.meditation.metime.R.id.level1;

public class Journey extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);

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
