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

        ImageButton level_btn_2 = (ImageButton) findViewById(R.id.level2);
        level_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), level2.class);
                startActivity(intent);
            }
        });

        ImageButton level_btn_3 = (ImageButton) findViewById(R.id.level3);
        level_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), level3.class);
                startActivity(intent);
            }
        });

        ImageButton level_btn_4 = (ImageButton) findViewById(R.id.level4);
        level_btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), level4.class);
                startActivity(intent);
            }
        });

        ImageButton level_btn_5 = (ImageButton) findViewById(R.id.level5);
        level_btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), level5.class);
                startActivity(intent);
            }
        });

        ImageButton level_btn_6 = (ImageButton) findViewById(R.id.level6);
        level_btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), level6.class);
                startActivity(intent);
            }
        });

        ImageButton level_btn_7 = (ImageButton) findViewById(R.id.level7);
        level_btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), level7.class);
                startActivity(intent);
            }
        });


    }
}
