package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.HuoLiveListFragment;
import dagger.Component;

@Component()
public interface HuoLiveFragmentComponent {

  void inject(HuoLiveListFragment fragment);

}
