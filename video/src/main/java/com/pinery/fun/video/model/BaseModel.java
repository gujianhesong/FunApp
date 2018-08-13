package com.pinery.fun.video.model;

import com.pinery.fun.video.api.RetrofitClient;

public abstract class BaseModel<T> implements IVideoModel<T> {

  public <T> T getApiService(String url, Class<T> cl) {
    return RetrofitClient.getInstance().getApiService(url, cl);
  }

}
