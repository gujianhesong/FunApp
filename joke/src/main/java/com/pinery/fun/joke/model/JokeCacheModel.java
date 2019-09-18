package com.pinery.fun.joke.model;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.model.BCacheModel;
import com.pinery.fun.joke.api.ApiService;
import com.pinery.fun.joke.api.JokeApi;
import com.pinery.fun.joke.api.RetrofitClient;
import com.pinery.fun.joke.bean.JokeDatasBean;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

public class JokeCacheModel extends BCacheModel {

  public Disposable requestJokes(final String type, long timestamp,
      OnDataCallback<JokeDatasBean> callback) {

    HashMap<String, Object> params = new HashMap<>();
    params.put("type", type);
    params.put("timestamp", timestamp);

    return requestData(params, callback, new OnRequestHandler<JokeDatasBean>() {
      @Override public Flowable<JokeDatasBean> onRequest(HashMap<String, Object> params) {
        return getApiService(JokeApi.Main, ApiService.class).requestJokeData(params);
      }

      @Override public HashMap<String, Object> onPrepareNextParams(JokeDatasBean data) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("type", type);
        params.put("timestamp", data.getTimestamp());
        return params;
      }

      @Override public String onPrepareCacheKey(HashMap<String, Object> params) {
        return null;
      }
    });
  }

  public <T> T getApiService(String url, Class<T> cl) {
    return RetrofitClient.getInstance().getApiService(url, cl);
  }
}
