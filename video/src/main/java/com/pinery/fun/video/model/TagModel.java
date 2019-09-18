package com.pinery.fun.video.model;

import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.model.BCacheModel;
import com.pinery.fun.video.api.ApiService;
import com.pinery.fun.video.api.HuoApi;
import com.pinery.fun.video.api.RetrofitClient;
import com.pinery.fun.video.bean.HashTagItemsBean;
import com.pinery.fun.video.bean.TagItemsBean;
import com.pinery.fun.video.bean.SearchTagListBean;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

public class TagModel extends BCacheModel {
  private static final int COUNT = 6;

  public <T> T getApiService(String url, Class<T> cl) {
    return RetrofitClient.getInstance().getApiService(url, cl);
  }

  public Disposable requestTagList(final OnDataCallback<SearchTagListBean> callback) {
    HashMap<String, Object> params = createHashMapWithCommonParams();
    params.put("offset", 0);
    params.put("count", COUNT);

    return requestData(params, callback, new OnRequestHandler<SearchTagListBean>() {
      @Override public Flowable<SearchTagListBean> onRequest(HashMap<String, Object> params) {
        return getApiService(HuoApi.Main, ApiService.class).requestSearchTagList(params);
      }

      @Override public HashMap<String, Object> onPrepareNextParams(SearchTagListBean data) {
        HashMap<String, Object> params = createHashMapWithCommonParams();
        params.put("offset", COUNT * 1);
        params.put("count", COUNT);
        return params;
      }

      @Override public String onPrepareCacheKey(HashMap<String, Object> params) {
        return "key_tag_list" + "_" + params.get("offset") + "_" + params.get("count");
      }
    });
  }

  public Disposable requestTagItems(final int tagId, final int page, final OnDataCallback<TagItemsBean> callback) {
    HashMap<String, Object> params = createHashMapWithCommonParams();
    params.put("offset", page * COUNT);
    params.put("count", COUNT);

    return requestData(params, callback, new OnRequestHandler<TagItemsBean>() {
      @Override public Flowable<TagItemsBean> onRequest(HashMap<String, Object> params) {
        return getApiService(HuoApi.Main, ApiService.class).requestSearchTagItems(tagId, params);
      }

      @Override public HashMap<String, Object> onPrepareNextParams(TagItemsBean data) {
        HashMap<String, Object> params = createHashMapWithCommonParams();
        params.put("offset", (page+1) * COUNT);
        params.put("count", COUNT);
        return params;
      }

      @Override public String onPrepareCacheKey(HashMap<String, Object> params) {
        return "key_tag_items" + "_" + params.get("offset") + "_" + params.get("count");
      }
    });

  }

  public Disposable requestHashTagItems(final String hashtag, final int page, final OnDataCallback<HashTagItemsBean> callback) {
    HashMap<String, Object> params = createHashMapWithCommonParams();
    final int pageSize = 20;
    if (page == 0){
      params.put("min_time", 0);
    }else{
      params.put("max_time", 0);
    }
    params.put("count", pageSize);
    params.put("offset", page * pageSize);

    return requestData(params, callback, new OnRequestHandler<HashTagItemsBean>() {
      @Override public Flowable<HashTagItemsBean> onRequest(HashMap<String, Object> params) {
        return getApiService(HuoApi.Main, ApiService.class).requestHashTagItems(hashtag, params);
      }

      @Override public HashMap<String, Object> onPrepareNextParams(HashTagItemsBean data) {
        HashMap<String, Object> params = createHashMapWithCommonParams();
        params.put("max_time", 0);
        params.put("count", pageSize);
        params.put("offset", (page+1) * pageSize);
        return params;
      }

      @Override public String onPrepareCacheKey(HashMap<String, Object> params) {
        return "key_hashtag_items" + "_" + params.get("offset") + "_" + params.get("count");
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

  private HashMap createHashMapWithCommonParams2() {
    HashMap<String, Object> hashMap = new HashMap<>();

    hashMap.put("iid", "42991411996");
    hashMap.put("device_id", "57063848101");
    hashMap.put("version_code", "373");
    hashMap.put("version_name", "3.7.3");

    hashMap.put("device_type", "SM-G9350");
    hashMap.put("device_brand", "samsung");
    hashMap.put("os_api", "22");
    hashMap.put("os_version", "6.0");

    hashMap.put("resolution", "1080*1920");
    hashMap.put("dpi", "480");

    hashMap.put("manifest_version_code", "373");
    hashMap.put("update_version_code", "3732");

    return hashMap;
  }
}
