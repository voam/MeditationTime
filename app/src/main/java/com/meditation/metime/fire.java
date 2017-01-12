package com.meditation.metime;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class fire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        // create an object of media controller
        MediaController mediaController = new MediaController(this);

        VideoView level1_video = (VideoView)findViewById(R.id.video);
        level1_video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fire));

        level1_video.setMediaController(mediaController);
    }
}
