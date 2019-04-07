package com.pinery.fun.joke.dagger;

import com.pinery.fun.joke.ui.fragment.JokeListFragment;
import dagger.Component;

@Component()
public interface JokeFragmentComponent {

  void inject(JokeListFragment fragment);
}
