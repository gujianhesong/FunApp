package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.SearchVideoFragment;
import dagger.Component;

@Component()
public interface SearchVideoFragmentComponent {

  void inject(SearchVideoFragment fragment);

}
