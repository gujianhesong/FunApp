package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.pinery.fun.video.bean.CommentListBean;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */

public interface HuoCommentsContract {

  interface View extends IView {
    void updateList(CommentListBean data);

    void error(Throwable throwable);
  }

  interface Presenter extends IPresenter<View> {
    void loadData(String id, int page);
  }
}
