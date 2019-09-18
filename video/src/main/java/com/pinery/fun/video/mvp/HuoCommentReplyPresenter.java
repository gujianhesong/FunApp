package com.pinery.fun.video.mvp;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.video.bean.CommentReplyListBean;
import com.pinery.fun.video.model.HuoCommentReplyModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-26.
 */
public class HuoCommentReplyPresenter extends BaseRxJavaPresenter<HuoCommentReplyContract.View>
    implements HuoCommentReplyContract.Presenter {

  private HuoCommentReplyModel model;

  @Inject public HuoCommentReplyPresenter() {
    model = new HuoCommentReplyModel();
  }

  @Override public void onStart() {
  }

  @Override public void loadData(String id, int page) {
    LogUtil.printStack("page:" + page);
    addDisposable(model.loadData(id, page, new OnDataCallback<CommentReplyListBean>() {
      @Override public void onSuccess(CommentReplyListBean bean) {
        LogUtil.i("page:" + bean);
        if (mView != null) {
          mView.updateList(bean);
        }
      }

      @Override public void onError(Throwable throwable) {
        if (mView != null) {
          mView.error(throwable);
        }
      }
    }));
  }
}
