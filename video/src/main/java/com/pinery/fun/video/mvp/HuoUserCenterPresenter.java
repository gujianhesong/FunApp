package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.fun.video.bean.HuoUserCenterBean;
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

  @Override public void refreshData(String userId) {
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
}
