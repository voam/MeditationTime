package com.meditation.metime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.meditation.metime.R.id.Bala_btn;
import static com.meditation.metime.R.id.Journey_btn;
import static com.meditation.metime.R.id.Mood_btn;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //navigate to journey section
        Button Jou_btn = (Button) findViewById(Journey_btn);
        Jou_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Journey.class);
                startActivity(intent);
            }
        });

        //navigate to mood section
        Button mo_btn = (Button) findViewById(Mood_btn);
        mo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Progress.class);
                startActivity(intent);
            }
        });

        //navigate to mood section
        Button balancing_btn = (Button) findViewById(Bala_btn);
        balancing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Balancing.class);
                startActivity(intent);
            }
        });

    }
}
