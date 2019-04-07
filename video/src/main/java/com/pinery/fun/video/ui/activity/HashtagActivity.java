package com.pinery.fun.video.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.pinery.base.activity.AgentActivity;
import com.pinery.fun.video.common.Constants;
import com.pinery.fun.video.ui.fragment.HashtagVideoListFragment;

@Route(path = Constants.PATH_HASH_TAG)
public class HashtagActivity extends AgentActivity {

  public static void navigate(Context context, String hashtag){
    Intent intent = new Intent(context, HashtagActivity.class);
    intent.putExtra("hashtag", hashtag);
    context.startActivity(intent);
  }

  @Override protected Class<? extends Fragment> provideFragmentClass() {
    return HashtagVideoListFragment.class;
  }
}
