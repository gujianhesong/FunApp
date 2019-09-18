package com.pinery.fun.video.dagger;

import com.pinery.fun.video.ui.fragment.SearchUserFragment;
import dagger.Component;

@Component()
public interface SearchUserFragmentComponent {

  void inject(SearchUserFragment fragment);

}
