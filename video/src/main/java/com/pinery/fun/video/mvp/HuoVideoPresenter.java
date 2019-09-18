package com.pinery.fun.video.mvp;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.video.bean.HuoVideoBean;
import com.pinery.fun.video.model.HuoVideoModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-11.
 */
public class HuoVideoPresenter extends BaseRxJavaPresenter<HuoVideoContract.View>
    implements HuoVideoContract.Presenter {

  private HuoVideoModel model;

  @Inject public HuoVideoPresenter() {
    model = new HuoVideoModel();
  }

  @Override public void onStart() {
  }

  @Override public void refreshData(boolean firstRefresh) {
    if (firstRefresh) {
      addDisposable(model.firstRefreshData(new OnDataCallback<HuoVideoBean>() {
        @Override public void onSuccess(HuoVideoBean bean) {
          if(mView != null){
            mView.updateList(true, bean);
          }
        }

        @Override public void onError(Throwable throwable) {
          if(mView != null){
            mView.error(throwable);
          }
        }
      }));
    } else {
      addDisposable(model.refreshData(new OnDataCallback<HuoVideoBean>() {
        @Override public void onSuccess(HuoVideoBean bean) {
          if(mView != null){
            mView.updateList(true, bean);
          }
        }

        @Override public void onError(Throwable throwable) {
          if(mView != null){
            mView.error(throwable);
          }
        }
      }));
    }
  }

  @Override public void loadMoreData(int page) {
    addDisposable(model.loadMoreData(page, new OnDataCallback<HuoVideoBean>() {
      @Override public void onSuccess(HuoVideoBean bean) {
        LogUtil.i("page:" + bean);
        if(mView != null){
          mView.updateList(false, bean);
        }
      }

      @Override public void onError(Throwable throwable) {
        if(mView != null){
          mView.error(throwable);
        }
      }
    }));
  }
}
