package com.pinery.fun.video.mvp;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.video.bean.HuoUserVideoListBean;
import com.pinery.fun.video.model.HuoUserCenterModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-9-2
 */
public class HuoUserVideoPresenter extends BaseRxJavaPresenter<HuoUserCenterContract.UserVideoView>
    implements HuoUserCenterContract.UserVideoPresenter {

  private HuoUserCenterModel model;

  @Inject public HuoUserVideoPresenter() {
    model = new HuoUserCenterModel();
  }

  @Override public void onStart() {
  }

  @Override
  public void refreshData(String userId, boolean firstRefresh) {
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
  public void loadMoreData(String userId, int page) {
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
