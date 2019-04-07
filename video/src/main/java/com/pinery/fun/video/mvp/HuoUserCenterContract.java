package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.pinery.fun.video.bean.HuoUserCenterBean;
import com.pinery.fun.video.bean.HuoUserVideoListBean;

/**
 * @author hesong
 * @time 2018/9/2
 * @desc
 */

public interface HuoUserCenterContract {

  interface View extends IView {
    void update(HuoUserCenterBean bean);
    void updateList(boolean isRefresh, HuoUserVideoListBean bean);

    void error(Throwable throwable);
  }

  interface Presenter extends IPresenter<View> {
    void requestUserInfo(String userId);
    void refreshVideoList(String userId, boolean firstRefresh);
    void loadMoreVideoList(String userId, int page);
  }

}
