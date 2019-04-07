package com.pinery.fun.joke.mvp;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.pinery.fun.joke.bean.JokeDatasBean;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */

public interface JokeContract {

  interface View extends IView {
    void updateList(boolean isRefresh, JokeDatasBean data);

    void onFailure(boolean isCancel, Throwable throwable);
  }

  interface Presenter extends IPresenter<View> {
    void requestData(String type, long timestamp, boolean isRefresh);
  }
}
