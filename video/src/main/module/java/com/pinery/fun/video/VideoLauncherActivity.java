package com.pinery.fun.video;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.alibaba.android.arouter.launcher.ARouter;

public class VideoLauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().build("/video/main").navigation();
        finish();
    }

}
