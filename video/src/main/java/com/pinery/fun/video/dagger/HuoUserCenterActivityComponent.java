package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.activity.UserCenterActivity;
import dagger.Component;

@Component() public interface HuoUserCenterActivityComponent {

  void inject(UserCenterActivity activity);
}
