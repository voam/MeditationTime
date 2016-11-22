package com.meditation.metime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.*;



import static com.meditation.metime.R.id.meditation_btn;
import static com.meditation.metime.R.id.music_btn;
import static com.meditation.metime.R.id.pro_btn;
import static com.meditation.metime.R.id.quote_btn;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //navigate to meditation type selection(Main2Activity)
        Button med_btn = (Button) findViewById(meditation_btn);
        med_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

        // navigate to Music section
        Button mus_btn = (Button) findViewById(music_btn);
        mus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Music.class);
                startActivity(intent);
            }
        });

        //navigate to Progress section
        Button progress_btn = (Button) findViewById(pro_btn);
        progress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Progress.class);
                startActivity(intent);
            }
        });

        //navigate to quote section
        Button quo_btn = (Button) findViewById(quote_btn);
        quo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Quote_day.class);
                startActivity(intent);
            }
        });

    }
}
