package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.HuoCityListFragment;
import dagger.Component;

@Component() public interface HuoCityFragmentComponent {

  void inject(HuoCityListFragment fragment);
}
