package com.pinery.fun.video.mvp;

import com.google.gson.Gson;
import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.video.bean.HuoLiveBean;
import com.pinery.fun.video.callback.OnDataCallback;
import com.pinery.fun.video.model.HuoLiveModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-11.
 */

public class HuoLivePresenter extends BaseRxJavaPresenter<HuoLiveContract.View>
    implements HuoLiveContract.Presenter {

  private HuoLiveModel model;

  @Inject public HuoLivePresenter() {
    model = new HuoLiveModel();
  }

  @Override public void onStart() {
  }

  @Override public void refreshData(boolean firstRefresh) {
    if(firstRefresh){
      addDisposable(model.firstRefreshData(new OnDataCallback<HuoLiveBean>() {
        @Override public void onSuccess(HuoLiveBean bean) {
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
    }else{
      addDisposable(model.refreshData(new OnDataCallback<HuoLiveBean>() {
        @Override public void onSuccess(HuoLiveBean bean) {
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
    LogUtil.printStack("page:"+page);
    addDisposable(model.loadMoreData(page, new OnDataCallback<HuoLiveBean>() {
      @Override public void onSuccess(HuoLiveBean bean) {
        LogUtil.i("page:"+bean);
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
