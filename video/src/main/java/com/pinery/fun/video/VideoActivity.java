package com.pinery.fun.video;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.pinery.base.activity.AgentActivity;
import com.pinery.fun.video.ui.fragment.HomeFragment;

@Route(path = "/video/main")
public class VideoActivity extends AgentActivity {

  public static void navigate(Context context){
    context.startActivity(new Intent(context, VideoActivity.class));
  }

  @Override protected Class<? extends Fragment> provideFragmentClass() {
    return HomeFragment.class;
  }
}
