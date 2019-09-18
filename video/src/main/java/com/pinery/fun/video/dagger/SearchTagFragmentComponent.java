package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.SearchTagFragment;
import dagger.Component;

@Component()
public interface SearchTagFragmentComponent {

  void inject(SearchTagFragment fragment);

}
