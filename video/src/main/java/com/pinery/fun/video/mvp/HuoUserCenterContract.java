package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.pinery.fun.video.bean.HuoUserCenterBean;
import com.pinery.fun.video.bean.HuoVideoBean;

/**
 * @author hesong
 * @time 2018/9/2
 * @desc
 */

public interface HuoUserCenterContract {

  interface View extends IView {
    void update(HuoUserCenterBean bean);

    void error(Throwable throwable);
  }

  interface Presenter extends IPresenter<View> {
    void refreshData(String userId);
  }

}
