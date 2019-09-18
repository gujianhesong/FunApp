package com.pinery.fun.video.mvp;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.mvp.BaseRxJavaPresenter;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.video.bean.SearchBean;
import com.pinery.fun.video.model.SearchModel;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-11.
 */
public class SearchPresenter extends BaseRxJavaPresenter<SearchContract.View>
    implements SearchContract.Presenter {

  public static int SEARCH_TYPE_USER = 1;
  public static int SEARCH_TYPE_VIDEO = 2;
  public static int SEARCH_TYPE_TAG = 3;
  public static int SEARCH_TYPE_SONG = 4;

  private SearchModel model;

  @Inject public SearchPresenter() {
    model = new SearchModel();
  }

  @Override public void onStart() {
  }

  @Override public void refreshData(final String keyword, final int searchType) {
    addDisposable(
        model.refreshData(keyword, searchType, new OnDataCallback<SearchBean>() {
          @Override public void onSuccess(SearchBean bean) {
            if (mView != null) {
              mView.updateList(keyword, true, bean);
            }
          }

          @Override public void onError(Throwable throwable) {
            if (mView != null) {
              mView.error(throwable);
            }
          }
        }));
  }

  @Override public void loadMoreData(final String keyword, final int searchType, int page) {
    addDisposable(model.loadMoreData(keyword, searchType, page,
        new OnDataCallback<SearchBean>() {
          @Override public void onSuccess(SearchBean bean) {
            LogUtil.i("page:" + bean);
            if (mView != null) {
              mView.updateList(keyword, false, bean);
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
