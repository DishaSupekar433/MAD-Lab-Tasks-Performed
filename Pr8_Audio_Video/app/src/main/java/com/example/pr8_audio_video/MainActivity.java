package com.example.pr8_audio_video;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button play, pause, stop;
    VideoView v;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        v = findViewById(R.id.videoView);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.audio);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
        String path = "android.resource://"+getPackageName()+"/raw/video";
        v.setVideoPath(path);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(v);
        mediaController.setMediaPlayer(v);
        v.setMediaController(mediaController);
        v.start();
    }
}