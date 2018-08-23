package com.pinery.fun.video.model;

import com.pinery.base.rxjava.RetryWithDelayFunc;
import com.pinery.fun.video.api.ApiService;
import com.pinery.fun.video.api.HuoApi;
import com.pinery.fun.video.bean.HuoCityBean;
import com.pinery.fun.video.callback.OnDataCallback;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;

public class HuoCityModel extends BaseModel<HuoCityBean> implements IModel<HuoCityBean> {

  @Override public Disposable firstRefreshData(final OnDataCallback<HuoCityBean> callback) {
    HashMap<String, Object> hashMap = createHashMapWithCommonParams();

    return getApiService(HuoApi.Main, ApiService.class).firstRefreshCityData(hashMap)
        .retryWhen(new RetryWithDelayFunc())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<HuoCityBean>() {
          @Override public void accept(@NonNull HuoCityBean bean) throws Exception {
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

  @Override public Disposable refreshData(final OnDataCallback<HuoCityBean> callback) {
    HashMap<String, Object> hashMap = createHashMapWithCommonParams();

    return getApiService(HuoApi.Main, ApiService.class).refreshCityData(hashMap)
        .retryWhen(new RetryWithDelayFunc())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<HuoCityBean>() {
          @Override public void accept(@NonNull HuoCityBean bean) throws Exception {
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

  @Override public Disposable loadMoreData(int page, final OnDataCallback<HuoCityBean> callback) {
    HashMap<String, Object> hashMap = createHashMapWithCommonParams();
    hashMap.put("max_time", System.currentTimeMillis());
    hashMap.put("offset", page * 10 + 1);

    return getApiService(HuoApi.Main, ApiService.class).loadMoreCityData(hashMap)
        .retryWhen(new RetryWithDelayFunc())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<HuoCityBean>() {
          @Override public void accept(@NonNull HuoCityBean bean) throws Exception {
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
}
