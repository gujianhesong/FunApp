package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.video.bean.HuoUserCenterBean;
import com.pinery.fun.video.bean.HuoUserVideoListBean;
import com.pinery.fun.video.callback.OnDataCallback;
import com.pinery.fun.video.model.HuoUserCenterModel;

import javax.inject.Inject;

/**
 * Created by gujian on 2018-9-2
 */
public class HuoUserCenterPresenter extends BaseRxJavaPresenter<HuoUserCenterContract.View>
    implements HuoUserCenterContract.Presenter {

  private HuoUserCenterModel model;

  @Inject public HuoUserCenterPresenter() {
    model = new HuoUserCenterModel();
  }

  @Override public void onStart() {
  }

  @Override public void requestUserInfo(String userId) {
    addDisposable(model.requestUserCenterInfo(userId, new OnDataCallback<HuoUserCenterBean>() {
      @Override public void onSuccess(HuoUserCenterBean bean) {
        if (mView != null) {
          mView.update(bean);
        }
      }

      @Override public void onError(Throwable throwable) {
        if (mView != null) {
          mView.error(throwable);
        }
      }
    }));
  }

  @Override
  public void refreshVideoList(String userId, boolean firstRefresh) {
    addDisposable(model.refreshData(userId, new OnDataCallback<HuoUserVideoListBean>() {
      @Override public void onSuccess(HuoUserVideoListBean bean) {
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

  @Override
  public void loadMoreVideoList(String userId, int page) {
    LogUtil.printStack("page:" + page);
    addDisposable(model.loadMoreData(userId, page, new OnDataCallback<HuoUserVideoListBean>() {
      @Override public void onSuccess(HuoUserVideoListBean bean) {
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
