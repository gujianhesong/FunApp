package com.pinery.fun.joke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.alibaba.android.arouter.launcher.ARouter;
import com.pinery.fun.joke.common.Constants;

public class JokeLauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().build(Constants.PATH_JOKE_MAIN).navigation();
        finish();
    }

}
