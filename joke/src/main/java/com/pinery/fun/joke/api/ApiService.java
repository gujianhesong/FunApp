package com.pinery.fun.joke.api;

import com.pinery.fun.joke.bean.JokeDatasBean;
import io.reactivex.Flowable;
import java.util.HashMap;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {

  /**
   * 首次刷新视频列表
   */
  @GET("http://joke.pinery.cn/get_jokes")
  Flowable<JokeDatasBean> requestJokeData(@QueryMap HashMap<String, Object> map);
}
