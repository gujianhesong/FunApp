package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.HuoVideoListFragment;
import dagger.Component;

@Component()
public interface HuoVideoFragmentComponent {

  void inject(HuoVideoListFragment fragment);

}
