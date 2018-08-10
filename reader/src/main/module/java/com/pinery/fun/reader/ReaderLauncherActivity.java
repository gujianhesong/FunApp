package com.pinery.fun.reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ReaderLauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader_launcher);
    }

    public void gotoReader(View view){
        startActivity(new Intent(this, ReaderActivity.class));
    }
}
