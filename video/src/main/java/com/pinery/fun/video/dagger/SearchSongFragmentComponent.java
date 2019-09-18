package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.SearchSongFragment;
import dagger.Component;

@Component()
public interface SearchSongFragmentComponent {

  void inject(SearchSongFragment fragment);

}
