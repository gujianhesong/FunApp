package com.pinery.fun.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class VideoLauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_launcher);
    }

    public void gotoVideo(View view){
        startActivity(new Intent(this, VideoActivity.class));
    }
}
