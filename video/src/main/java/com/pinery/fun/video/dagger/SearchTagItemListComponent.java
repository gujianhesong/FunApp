package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.TagItemListFragment;

import dagger.Component;

@Component() public interface SearchTagItemListComponent {

  void inject(TagItemListFragment fragment);
}
