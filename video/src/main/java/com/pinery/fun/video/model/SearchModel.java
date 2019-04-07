package com.pinery.fun.video.model;

import com.pinery.base.rxjava.RetryWithDelayFunc;
import com.pinery.fun.video.api.ApiService;
import com.pinery.fun.video.api.HuoApi;
import com.pinery.fun.video.bean.HashTagItemsBean;
import com.pinery.fun.video.bean.SearchTagItemsBean;
import com.pinery.fun.video.bean.SearchTagListBean;
import com.pinery.fun.video.callback.OnDataCallback;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SearchModel extends BaseModel<Object> {

  public Disposable requestTagList(final OnDataCallback<SearchTagListBean> callback) {
    HashMap<String, Object> hashMap = createHashMapWithCommonParams();
    hashMap.put("offset", 0);
    hashMap.put("count", 6);

    return getApiService(HuoApi.Main, ApiService.class).requestSearchTagList(hashMap)
        .retryWhen(new RetryWithDelayFunc())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<SearchTagListBean>() {
          @Override public void accept(@NonNull SearchTagListBean bean) throws Exception {
            if (callback != null) {
              callback.onSuccess(bean);
            }
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(@NonNull Throwable throwable) throws Exception {
            if (callback != null) {
              callback.onError(throwable);
            }
          }
        });
  }

  public Disposable requestTagItems(final int tagId, int page, final OnDataCallback<SearchTagItemsBean> callback) {
    HashMap<String, Object> hashMap = createHashMapWithCommonParams();
    int pageSize = 6;
    hashMap.put("offset", page * pageSize);
    hashMap.put("count", pageSize);

    return getApiService(HuoApi.Main, ApiService.class).requestSearchTagItems(tagId, hashMap)
            .retryWhen(new RetryWithDelayFunc())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<SearchTagItemsBean>() {
              @Override public void accept(@NonNull SearchTagItemsBean bean) throws Exception {
                if (callback != null) {
                  callback.onSuccess(bean);
                }
              }
            }, new Consumer<Throwable>() {
              @Override public void accept(@NonNull Throwable throwable) throws Exception {
                if (callback != null) {
                  callback.onError(throwable);
                }
              }
            });
  }

  public Disposable requestHashTagItems(final String hashtag, int page, final OnDataCallback<HashTagItemsBean> callback) {
    HashMap<String, Object> hashMap = createHashMapWithCommonParams();

    int pageSize = 20;
    if (page == 0){
      hashMap.put("min_time", 0);
    }else{
      hashMap.put("max_time", 0);
    }
    hashMap.put("count", pageSize);
    hashMap.put("offset", page * pageSize);

    return getApiService(HuoApi.Main, ApiService.class).requestHashTagItems(hashtag, hashMap)
        .retryWhen(new RetryWithDelayFunc())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<HashTagItemsBean>() {
          @Override public void accept(@NonNull HashTagItemsBean bean) throws Exception {
            if (callback != null) {
              callback.onSuccess(bean);
            }
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(@NonNull Throwable throwable) throws Exception {
            if (callback != null) {
              callback.onError(throwable);
            }
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
