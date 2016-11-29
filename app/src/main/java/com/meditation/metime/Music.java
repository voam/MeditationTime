package com.meditation.metime;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Music extends AppCompatActivity {

    MediaPlayer music1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        music1= MediaPlayer.create(this, R.raw.dark_knight_audio);
    }
}
