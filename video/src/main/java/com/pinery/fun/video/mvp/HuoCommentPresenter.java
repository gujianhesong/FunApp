package com.pinery.fun.video.mvp;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.video.bean.CommentListBean;
import com.pinery.fun.video.model.HuoCommentModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-26.
 */
public class HuoCommentPresenter extends BaseRxJavaPresenter<HuoCommentsContract.View>
    implements HuoCommentsContract.Presenter {

  private HuoCommentModel model;

  @Inject public HuoCommentPresenter() {
    model = new HuoCommentModel();
  }

  @Override public void onStart() {
  }

  @Override public void loadData(String id, int page) {
    LogUtil.printStack("page:" + page);
    addDisposable(model.loadData(id, page, new OnDataCallback<CommentListBean>() {
      @Override public void onSuccess(CommentListBean bean) {
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
