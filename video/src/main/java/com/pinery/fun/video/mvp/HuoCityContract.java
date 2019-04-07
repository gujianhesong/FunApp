package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.pinery.fun.video.bean.HuoCityBean;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */

public interface HuoCityContract {

  interface View extends IView {
    void updateList(boolean isRefresh, HuoCityBean data);

    void error(Throwable throwable);
  }

  interface Presenter extends IPresenter<View> {
    void refreshData(boolean firstRefresh);
    void loadMoreData(int page);
  }

}
