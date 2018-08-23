package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.video.bean.HuoCityBean;
import com.pinery.fun.video.callback.OnDataCallback;
import com.pinery.fun.video.model.HuoCityModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-11.
 */
public class HuoCityPresenter extends BaseRxJavaPresenter<HuoCityContract.View>
    implements HuoCityContract.Presenter {

  private HuoCityModel model;

  @Inject public HuoCityPresenter() {
    model = new HuoCityModel();
  }

  @Override public void onStart() {
  }

  @Override public void refreshData(boolean firstRefresh) {
    if (firstRefresh) {
      addDisposable(model.firstRefreshData(new OnDataCallback<HuoCityBean>() {
        @Override public void onSuccess(HuoCityBean bean) {
          if (mView != null) {
            mView.updateList(true, bean);
          }
        }

        @Override public void onError(Throwable throwable) {
          if (mView != null) {
            mView.error(throwable);
          }
        }
      }));
    } else {
      addDisposable(model.refreshData(new OnDataCallback<HuoCityBean>() {
        @Override public void onSuccess(HuoCityBean bean) {
          if (mView != null) {
            mView.updateList(true, bean);
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

  @Override public void loadMoreData(int page) {
    LogUtil.printStack("page:" + page);
    addDisposable(model.loadMoreData(page, new OnDataCallback<HuoCityBean>() {
      @Override public void onSuccess(HuoCityBean bean) {
        LogUtil.i("page:" + bean);
        if (mView != null) {
          mView.updateList(false, bean);
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
