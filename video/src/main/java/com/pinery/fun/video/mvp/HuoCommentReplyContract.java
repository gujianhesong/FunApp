package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.pinery.fun.video.bean.CommentReplyListBean;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */

public interface HuoCommentReplyContract {

  interface View extends IView {
    void updateList(CommentReplyListBean data);

    void error(Throwable throwable);
  }

  interface Presenter extends IPresenter<View> {
    void loadData(String id, int page);
  }
}
