package com.pinery.fun.video.model;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.model.BCacheModel;
import com.pinery.fun.video.api.ApiService;
import com.pinery.fun.video.api.HuoApi;
import com.pinery.fun.video.api.RetrofitClient;
import com.pinery.fun.video.bean.SearchBean;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

public class SearchModel extends BCacheModel {
  private static int COUNT = 10;

  public <T> T getApiService(String url, Class<T> cl) {
    return RetrofitClient.getInstance().getApiService(url, cl);
  }

  public Disposable refreshData(final String keyword, final int searchType, OnDataCallback<SearchBean> callback) {

    final HashMap<String, Object> params = createHashMapWithCommonParams();
    params.put("query", keyword);
    params.put("user_action", "Initiative");
    params.put("click_rectify_bar", "0");
    params.put("search_type", searchType);
    params.put("count", COUNT);
    params.put("offset", 0);

    return requestData(params, callback, new OnRequestHandler<SearchBean>() {
      @Override public Flowable<SearchBean> onRequest(HashMap<String, Object> params) {
        return getApiService(HuoApi.Main, ApiService.class).searchData(params);
      }

      @Override public HashMap<String, Object> onPrepareNextParams(SearchBean data) {
        HashMap<String, Object> params = createHashMapWithCommonParams();
        params.put("query", keyword);
        params.put("user_action", "Initiative");
        params.put("click_rectify_bar", "0");
        params.put("search_type", searchType);
        params.put("count", COUNT);
        params.put("offset", 1 * COUNT);

        return params;
      }

      @Override public String onPrepareCacheKey(HashMap<String, Object> params) {
        return "key_search_" + searchType + "_" + params.get("offset") + "_" + params.get("count");
      }
    });
  }

  public Disposable loadMoreData(final String keyword, final int searchType, final int page,
      OnDataCallback<SearchBean> callback) {
    HashMap<String, Object> params = createHashMapWithCommonParams();
    params.put("query", keyword);
    params.put("user_action", "Initiative");
    params.put("click_rectify_bar", "0");
    params.put("search_type", searchType);
    params.put("count", COUNT);
    params.put("offset", page * COUNT);

    return requestData(params, callback, new OnRequestHandler<SearchBean>() {
      @Override public Flowable<SearchBean> onRequest(HashMap<String, Object> params) {
        return getApiService(HuoApi.Main, ApiService.class).searchData(params);
      }

      @Override public HashMap<String, Object> onPrepareNextParams(SearchBean data) {
        HashMap<String, Object> params = createHashMapWithCommonParams();
        params.put("query", keyword);
        params.put("user_action", "Initiative");
        params.put("click_rectify_bar", "0");
        params.put("search_type", searchType);
        params.put("count", COUNT);
        params.put("offset", (page + 1) * COUNT);

        return params;
      }

      @Override public String onPrepareCacheKey(HashMap<String, Object> params) {
        return "key_search_" + searchType + "_" + params.get("offset") + "_" + params.get("count");
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
