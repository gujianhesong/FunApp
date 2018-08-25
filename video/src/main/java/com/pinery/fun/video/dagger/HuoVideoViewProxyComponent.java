package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.viewproxy.HuoVideoListViewProxy;
import dagger.Component;

@Component()
public interface HuoVideoViewProxyComponent {

  void inject(HuoVideoListViewProxy viewProxy);

}
