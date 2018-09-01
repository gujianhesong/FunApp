package com.pinery.fun.video.model;

import com.pinery.base.rxjava.RetryWithDelayFunc;
import com.pinery.fun.video.api.ApiService;
import com.pinery.fun.video.api.HuoApi;
import com.pinery.fun.video.bean.CommentListBean;
import com.pinery.fun.video.callback.OnDataCallback;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;

public class HuoCommentModel extends BaseModel<CommentListBean> {

  public Disposable loadData(String id, int page, final OnDataCallback<CommentListBean> callback) {
    HashMap<String, Object> hashMap = createHashMapWithCommonParams();
    hashMap.put("offset", page * 20);

    return getApiService(HuoApi.Main, ApiService.class).loadComments(id, hashMap)
        .retryWhen(new RetryWithDelayFunc())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<CommentListBean>() {
          @Override public void accept(@NonNull CommentListBean commentBean) throws Exception {
            if (callback != null) {
              callback.onSuccess(commentBean);
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
