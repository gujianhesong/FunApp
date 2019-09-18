package com.pinery.fun.video.model;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.model.BCacheModel;
import com.pinery.fun.video.api.ApiService;
import com.pinery.fun.video.api.HuoApi;
import com.pinery.fun.video.api.RetrofitClient;
import com.pinery.fun.video.bean.CommentListBean;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

public class HuoCommentModel extends BCacheModel {
  private static final int COUNT = 20;

  public <T> T getApiService(String url, Class<T> cl) {
    return RetrofitClient.getInstance().getApiService(url, cl);
  }

  public Disposable loadData(final String id, final int page, final OnDataCallback<CommentListBean> callback) {
    HashMap<String, Object> params = createHashMapWithCommonParams();
    params.put("offset", page * COUNT);
    params.put("count", COUNT);

    return requestData(params, callback, new OnRequestHandler<CommentListBean>() {
      @Override public Flowable<CommentListBean> onRequest(HashMap<String, Object> params) {
        return getApiService(HuoApi.Main, ApiService.class).loadComments(id, params);
      }

      @Override public HashMap<String, Object> onPrepareNextParams(CommentListBean data) {
        HashMap<String, Object> params = createHashMapWithCommonParams();
        params.put("offset", (page+1) * COUNT);
        params.put("count", COUNT);
        return params;
      }

      @Override public String onPrepareCacheKey(HashMap<String, Object> params) {
        return "key_comment" + "_" + params.get("offset") + "_" + params.get("count");
      }
    });
  }

  private HashMap createHashMapWithCommonParams() {
    HashMap<String, Object> hashMap = new HashMap<>();

    hashMap.put("iid", "30236820662");
    hashMap.put("device_id", "48119665719");
    hashMap.put("version_code", "373");
    hashMap.put("version_name", "3.7.3");

    hashMap.put("device_type", "1603-A03");
    hashMap.put("device_brand", "360");
    hashMap.put("os_api", "23");
    hashMap.put("os_version", "6.0");

    hashMap.put("resolution", "1080*1920");
    hashMap.put("dpi", "480");

    hashMap.put("manifest_version_code", "373");
    hashMap.put("update_version_code", "3732");

    return hashMap;
  }
}
