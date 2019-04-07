package com.pinery.fun.joke.mvp;

import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.joke.bean.CancelException;
import com.pinery.fun.joke.bean.JokeDatasBean;
import com.pinery.fun.joke.callback.OnDataCallback;
import com.pinery.fun.joke.model.JokeModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-11.
 */
public class JokePresenter extends BaseRxJavaPresenter<JokeContract.View>
    implements JokeContract.Presenter {

  private JokeModel model;

  @Inject public JokePresenter() {
    model = new JokeModel();
  }

  @Override public void onStart() {
  }

  @Override public void requestData(final String type, long timestamp, final boolean isRefresh) {
    LogUtil.i("pre page:" + ", " + type + ", " + mView);

    addDisposable(model.requestData(type, timestamp, new OnDataCallback<JokeDatasBean>() {
      @Override public void onSuccess(JokeDatasBean bean) {
        LogUtil.i("post page:" + bean + ", " + type + ", " + mView);
          //通知更新数据
          notifyUpdateList(bean, isRefresh);
      }

      @Override public void onError(Throwable throwable) {
        LogUtil.i("post page:" + throwable + ", " + type + ", " + mView);
          if (mView != null) {
            if (throwable instanceof CancelException){
              mView.onFailure(true, throwable);
            }else{
              mView.onFailure(false, throwable);
            }
          }
      }
    }));

  }

  private void notifyUpdateList(JokeDatasBean bean, boolean isRefresh){
    LogUtil.i("bean:" + bean + ", " + isRefresh + ", " + mView);
    if (mView != null) {
      mView.updateList(isRefresh, bean);
    }
  }

}
