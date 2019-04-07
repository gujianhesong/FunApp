package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.pinery.fun.video.bean.HashTagItemsBean;

/**
 * @author hesong
 * @time 2019/3/21
 * @desc
 */

public interface HashTagContract {

  interface HashTagItemsView extends IView {
    void updateHashTagList(HashTagItemsBean bean, boolean refresh);
    void error(Throwable throwable);
  }

  interface HashTagItemsPresenter extends IPresenter<HashTagItemsView> {
    void refreshData(String hashTag);
    void loadMoreData(String hashTag, int page);
  }

}
