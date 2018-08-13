package com.pinery.fun.video.mvp;

import com.google.gson.Gson;
import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.video.bean.HuoVideoBean;
import com.pinery.fun.video.callback.OnDataCallback;
import com.pinery.fun.video.model.HuoVideoModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-11.
 */

public class HuoVideoPresenter extends BaseRxJavaPresenter<HuoVideoContract.View>
    implements HuoVideoContract.Presenter {

  private Gson gson = new Gson();
  private HuoVideoModel model;

  @Inject public HuoVideoPresenter() {
    model = new HuoVideoModel();
  }

  @Override public void onStart() {
  }

  @Override public void refreshData(boolean firstRefresh) {
    if(firstRefresh){
      addDisposable(model.firstRefreshData(new OnDataCallback<HuoVideoBean>() {
        @Override public void onSuccess(HuoVideoBean huoVideoBean) {
          mView.updateList(true, huoVideoBean);
        }

        @Override public void onError(Throwable throwable) {
          mView.error(throwable);
        }
      }));
    }else{
      addDisposable(model.refreshData(new OnDataCallback<HuoVideoBean>() {
        @Override public void onSuccess(HuoVideoBean huoVideoBean) {
          mView.updateList(true, huoVideoBean);
        }

        @Override public void onError(Throwable throwable) {
          mView.error(throwable);
        }
      }));
    }
  }

  @Override public void loadMoreData(int page) {
    LogUtil.printStack("page:"+page);
    addDisposable(model.loadMoreData(page, new OnDataCallback<HuoVideoBean>() {
      @Override public void onSuccess(HuoVideoBean huoVideoBean) {
        LogUtil.i("page:"+huoVideoBean);
        mView.updateList(false, huoVideoBean);
      }

      @Override public void onError(Throwable throwable) {
        mView.error(throwable);
      }
    }));
  }
}
