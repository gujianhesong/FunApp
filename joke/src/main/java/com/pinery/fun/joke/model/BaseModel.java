package com.pinery.fun.joke.model;

import com.pinery.fun.joke.api.RetrofitClient;

public abstract class BaseModel<D> {

  public <T> T getApiService(String url, Class<T> cl) {
    return RetrofitClient.getInstance().getApiService(url, cl);
  }
}
