package com.pinery.fun.video.model;

import com.pinery.base.callback.OnDataCallback;
import io.reactivex.disposables.Disposable;

/**
 * Created by gujian on 2018-08-22.
 */

public interface IModel<T> {

  public Disposable firstRefreshData(final OnDataCallback<T> callback);

  public Disposable refreshData(final OnDataCallback<T> callback);

  public Disposable loadMoreData(int page, final OnDataCallback<T> callback);
}
