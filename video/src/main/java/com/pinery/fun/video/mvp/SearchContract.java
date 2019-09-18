package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.pinery.fun.video.bean.SearchBean;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */

public interface SearchContract {

  interface View extends IView {
    void updateList(String keyword, boolean isRefresh, SearchBean data);

    void error(Throwable throwable);
  }

  interface Presenter extends IPresenter<View> {
    void refreshData(String keyword, int searchType);

    void loadMoreData(String keyword, int searchType, int page);
  }
}
