package com.pinery.fun.joke.model;

import com.pinery.base.rxjava.RetryWithDelayFunc;
import com.pinery.base.util.LogUtil;
import com.pinery.fun.joke.api.ApiService;
import com.pinery.fun.joke.api.JokeApi;
import com.pinery.fun.joke.bean.CancelException;
import com.pinery.fun.joke.bean.JokeDatasBean;
import com.pinery.fun.joke.callback.OnDataCallback;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;

public class JokeModel extends BaseModel<JokeDatasBean> {
  //缓存map
  private HashMap<String, JokeDatasBean> mCache = new HashMap<>();

  //是否启用缓存
  private boolean mEnableCache = true;

  public Disposable requestData(final String type, long timestamp,
      final OnDataCallback<JokeDatasBean> callback) {

    if(mEnableCache){
      //查找缓存是否存在
      JokeDatasBean cacheData = getFromCache(type, timestamp);
      if (cacheData != null) {
        //从缓存加载
        return requestFromCache(cacheData, type, timestamp, callback);
      }
    }

    //从网络加载
    return requestFromRemote(type, timestamp, callback);
  }

  public Disposable requestFromCache(JokeDatasBean cacheData, final String type, final long timestamp,
      final OnDataCallback<JokeDatasBean> callback) {

    return Flowable.just(cacheData).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnCancel(new Action() {
          @Override public void run() throws Exception {
            if (callback != null) {
              callback.onError(new CancelException("request canceled"));
            }
          }
        })
        .subscribe(new Consumer<JokeDatasBean>() {
          @Override public void accept(@NonNull JokeDatasBean bean) throws Exception {
            LogUtil.i("post page:" + bean + ", " + type);
            if (callback != null) {
              //通知加载成功
              notifySuccess(callback, bean, timestamp);

              //加载下一页数据
              innerRequestFromRemote(type, bean.getTimestamp(), callback, false, true, false);
            }
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(@NonNull Throwable throwable) throws Exception {
            LogUtil.i("post page:" + throwable + ", " + type);
            if (callback != null) {
              callback.onError(throwable);
            }
          }
        }, new Action() {
          @Override public void run() throws Exception {

          }
        });
  }

  public Disposable requestFromRemote(final String type,
      long timestamp,
      final OnDataCallback<JokeDatasBean> callback) {

    return innerRequestFromRemote(type, timestamp, callback, true, false, true);
  }

  /**
   *
   * @param type 类型
   * @param timestamp 时间戳
   * @param callback
   * @param loadNext 是否加载下一页
   * @param save2Cache 是否保存到缓存
   * @param notifyUpdate 是否通知更新
   * @return
   */
  public Disposable innerRequestFromRemote(final String type,
      final long timestamp,
      final OnDataCallback<JokeDatasBean> callback, final boolean loadNext,
      final boolean save2Cache, final boolean notifyUpdate) {

    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("type", type);
    hashMap.put("timestamp", timestamp);
    return getApiService(JokeApi.Main, ApiService.class).requestJokeData(hashMap)
        .retryWhen(new RetryWithDelayFunc())
        .subscribeOn(Schedulers.io())
        //.delay(3, TimeUnit.SECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .doOnCancel(new Action() {
          @Override public void run() throws Exception {
            if (callback != null) {
              callback.onError(new CancelException("request canceled"));
            }
          }
        })
        .subscribe(new Consumer<JokeDatasBean>() {
          @Override public void accept(@NonNull JokeDatasBean bean) throws Exception {
            if(notifyUpdate){
              //通知加载成功
              notifySuccess(callback, bean, timestamp);
            }

            if(mEnableCache){
              //处理是否保存到缓存
              if(save2Cache){
                addToCache(type, timestamp, bean);
              }

              //处理是否加载下一页数据
              if(loadNext){
                innerRequestFromRemote(type, bean.getTimestamp(), callback, false, true, false);
              }
            }

          }
        }, new Consumer<Throwable>() {
          @Override public void accept(@NonNull Throwable throwable) throws Exception {
            if (callback != null) {
              callback.onError(throwable);
            }
          }
        }, new Action() {
          @Override public void run() throws Exception {

          }
        });
  }

  private void addToCache(String type, long timestamp, JokeDatasBean bean) {
    LogUtil.i("bean:" + bean + ", " + type + ", " + timestamp);
    mCache.put(type + timestamp, bean);
  }

  private JokeDatasBean getFromCache(String type, long timestamp) {
    JokeDatasBean bean = mCache.remove(type + timestamp);
    LogUtil.i("bean:" + bean + ", " + type + ", " + timestamp);
    return bean;
  }

  private void notifySuccess(OnDataCallback<JokeDatasBean> callback, JokeDatasBean bean, long timestamp){
    LogUtil.i("bean:" + bean + ", " + timestamp + ", " + callback);
    if(callback != null){
      callback.onSuccess(bean);
    }
  }
}
