package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.HashtagVideoListFragment;
import dagger.Component;

@Component() public interface HashTagVideoListComponent {

  void inject(HashtagVideoListFragment fragment);
}
