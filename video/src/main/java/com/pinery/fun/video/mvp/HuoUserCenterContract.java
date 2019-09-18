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

  interface UserCenterView extends IView {
    void update(HuoUserCenterBean bean);

    void error(Throwable throwable);
  }

  interface UserVideoView extends IView {
    void updateList(boolean isRefresh, HuoUserVideoListBean bean);

    void error(Throwable throwable);
  }

  interface UserCenterPresenter extends IPresenter<UserCenterView> {
    void requestUserInfo(String userId);
  }

  interface UserVideoPresenter extends IPresenter<UserVideoView> {
    void refreshData(String userId, boolean firstRefresh);
    void loadMoreData(String userId, int page);
  }

}
