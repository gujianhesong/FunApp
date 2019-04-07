package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.SearchTagItemListFragment;

import dagger.Component;

@Component() public interface SearchTagItemListComponent {

  void inject(SearchTagItemListFragment fragment);
}
