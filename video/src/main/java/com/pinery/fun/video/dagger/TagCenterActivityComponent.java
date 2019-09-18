package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.activity.TagCenterActivity;
import dagger.Component;

@Component() public interface TagCenterActivityComponent {

  void inject(TagCenterActivity activity);
}
