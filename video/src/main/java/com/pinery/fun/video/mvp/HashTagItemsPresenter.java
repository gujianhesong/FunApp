package com.pinery.fun.video.mvp;

import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.fun.video.bean.HashTagItemsBean;
import com.pinery.fun.video.callback.OnDataCallback;
import com.pinery.fun.video.model.SearchModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2019-3-30
 */
public class HashTagItemsPresenter extends BaseRxJavaPresenter<HashTagContract.HashTagItemsView>
    implements HashTagContract.HashTagItemsPresenter {

  private SearchModel model;

  @Inject
  public HashTagItemsPresenter() {
    model = new SearchModel();
  }

  @Override
  public void onStart() {
  }

  @Override
  public void refreshData(String hashTag) {
    addDisposable(model.requestHashTagItems(hashTag, 0, new OnDataCallback<HashTagItemsBean>() {
      @Override
      public void onSuccess(HashTagItemsBean bean) {
        if (mView != null) {
          mView.updateHashTagList(bean, true);
        }
      }

      @Override
      public void onError(Throwable throwable) {
        if (mView != null) {
          mView.error(throwable);
        }
      }
    }));
  }

  @Override
  public void loadMoreData(String hashTag, int page) {
    addDisposable(model.requestHashTagItems(hashTag, page, new OnDataCallback<HashTagItemsBean>() {
      @Override
      public void onSuccess(HashTagItemsBean bean) {
        if (mView != null) {
          mView.updateHashTagList(bean, false);
        }
      }

      @Override
      public void onError(Throwable throwable) {
        if (mView != null) {
          mView.error(throwable);
        }
      }
    }));
  }
}
