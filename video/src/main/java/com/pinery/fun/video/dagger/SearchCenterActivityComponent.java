package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.activity.SearchCenterActivity;

import dagger.Component;

@Component() public interface SearchCenterActivityComponent {

  void inject(SearchCenterActivity activity);
}
