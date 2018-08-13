package com.pinery.test;

import dagger.Component;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */
@Component()
public interface TestFragmentComponent {

  void inject(TestFragment fragment);

}
