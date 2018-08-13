package com.pinery.test;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */

public interface TestContract {

  interface View extends IView {
    void showUpdate(String message);
  }

  interface Presenter extends IPresenter<View> {
    void checkUpdate();
  }

}
