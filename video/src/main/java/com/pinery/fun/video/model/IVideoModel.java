package com.pinery.fun.video.model;

import com.pinery.fun.video.callback.OnDataCallback;
import io.reactivex.disposables.Disposable;

public interface IVideoModel<T> {
    Disposable requestData(OnDataCallback<T> callback);
}
