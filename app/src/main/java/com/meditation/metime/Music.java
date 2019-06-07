/**
 *  MeDitationTime
 *
 *  Music.class: Controller class for the music section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;


public class Music extends BaseActivityWithDrawer {

    // enables drawer
    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the progress layout to the BaseActivityWithDrawer
        LayoutInflater.from(this).inflate(R.layout.activity_music, getFrame());
        Resources res = getResources();
        String[] song_titles = res.getStringArray(R.array.songs_array);
        // title 1
        RelativeLayoutButton m1_btn = new RelativeLayoutButton(this,R.id.M1_btn);
      //  m1_btn.setText(R.id.button_text, getResources().getText(R.string.title_1));
        m1_btn.setText(R.id.button_text, song_titles[0]);
        m1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextActivity(0);

            }
        });

        // title 2
        RelativeLayoutButton m2_btn = new RelativeLayoutButton(this,R.id.M2_btn);
       // m2_btn.setText(R.id.button_text, getResources().getText(R.string.title_2));
        m2_btn.setText(R.id.button_text, song_titles[1]);
        m2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextActivity(1);
            }
        });

        // title 3
        RelativeLayoutButton m3_btn = new RelativeLayoutButton(this,R.id.M3_btn);
       // m3_btn.setText(R.id.button_text, getResources().getText(R.string.title_3));
        m3_btn.setText(R.id.button_text, song_titles[2]);
        m3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextActivity(2);
            }
        });

        // title 4
        RelativeLayoutButton m4_btn = new RelativeLayoutButton(this,R.id.M4_btn);
      //  m4_btn.setText(R.id.button_text, getResources().getText(R.string.title_4));
        m4_btn.setText(R.id.button_text, song_titles[3]);
        m4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextActivity(3);
            }
        });

        // title 5
        RelativeLayoutButton m5_btn = new RelativeLayoutButton(this,R.id.M5_btn);
       // m5_btn.setText(R.id.button_text, getResources().getText(R.string.title_5));
        m5_btn.setText(R.id.button_text, song_titles[4]);
        m5_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextActivity(4);
            }
        });

        // title 6
        RelativeLayoutButton m6_btn = new RelativeLayoutButton(this,R.id.M6_btn);
       // m6_btn.setText(R.id.button_text, getResources().getText(R.string.title_6));
        m6_btn.setText(R.id.button_text, song_titles[5]);
        m6_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextActivity(5);
            }
        });

        // title 7
        RelativeLayoutButton m7_btn = new RelativeLayoutButton(this,R.id.M7_btn);
        //m7_btn.setText(R.id.button_text, getResources().getText(R.string.title_7));
        m7_btn.setText(R.id.button_text, song_titles[6]);
        m7_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextActivity(6);
            }
        });

        // title 8
        RelativeLayoutButton m8_btn = new RelativeLayoutButton(this,R.id.M8_btn);
       // m8_btn.setText(R.id.button_text, getResources().getText(R.string.title_8));
        m8_btn.setText(R.id.button_text, song_titles[7]);
        m8_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextActivity(7);
            }
        });

        // title 9
        RelativeLayoutButton m9_btn = new RelativeLayoutButton(this,R.id.M9_btn);
        //m9_btn.setText(R.id.button_text, getResources().getText(R.string.title_9));
        m9_btn.setText(R.id.button_text,  song_titles[8]);
        m9_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextActivity(8);
            }
        });
    }

    private void nextActivity(int songIndex) {

        Intent intent = new Intent(getApplicationContext(), Music_detail.class);
        intent.putExtra(Music_detail.INTENT_SONG_INDEX, songIndex);
        startActivity(intent);

    }

}