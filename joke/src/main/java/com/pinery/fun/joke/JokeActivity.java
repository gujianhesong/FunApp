package com.pinery.fun.joke;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.pinery.base.activity.AgentActivity;
import com.pinery.fun.joke.common.Constants;
import com.pinery.fun.joke.ui.fragment.HomeFragment;
import com.pinery.fun.joke.util.CleanLeakUtil;

@Route(path = Constants.PATH_JOKE_MAIN)
public class JokeActivity extends AgentActivity {

  public static void navigate(Context context) {
    context.startActivity(new Intent(context, JokeActivity.class));
  }

  @Override protected Class<? extends Fragment> provideFragmentClass() {
    return HomeFragment.class;
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    //防止JokeActivity退出后内存泄露不能销毁
    CleanLeakUtil.fixInputMethodManagerLeak(this);

    //清空Glide内存缓存
    Glide.get(getApplicationContext()).clearMemory();

    //通知gc
    JokeApplication.getInstance().notifyGc();

  }

}
