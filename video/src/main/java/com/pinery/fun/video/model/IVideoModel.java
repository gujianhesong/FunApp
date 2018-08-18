package com.pinery.fun.video.model;

import com.pinery.fun.video.callback.OnDataCallback;
import io.reactivex.disposables.Disposable;

public interface IVideoModel<T> {

  /**
   * 首次进入刷新
   * @param callback
   * @return
   */
  Disposable firstRefreshData(OnDataCallback<T> callback);

  /**
   * 刷新
   * @param callback
   * @return
   */
  Disposable refreshData(OnDataCallback<T> callback);

  /**
   * 加载更多
   * @param page
   * @param callback
   * @return
   */
  Disposable loadMoreData(int page, OnDataCallback<T> callback);
}
