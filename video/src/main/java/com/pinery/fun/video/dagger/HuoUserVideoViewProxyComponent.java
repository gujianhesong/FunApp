package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.viewproxy.HuoUserVideoListViewProxy;
import dagger.Component;

@Component()
public interface HuoUserVideoViewProxyComponent {

  void inject(HuoUserVideoListViewProxy viewProxy);

}
