package com.pinery.base.model;

import com.alibaba.android.arouter.utils.TextUtils;
import com.pinery.base.bean.CancelException;
import com.pinery.base.callback.OnDataCallback;
import com.pinery.base.util.LogUtil;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import org.reactivestreams.Publisher;

/**
 * Created by gujian on 2019/4/9.
 */

public abstract class BCacheModel {

  public interface OnRequestNoCacheHandler<D>{
    Flowable<D> onRequest(HashMap<String, Object> params);
  }

  public interface OnRequestHandler <D> extends OnRequestNoCacheHandler<D>{
    HashMap<String, Object> onPrepareNextParams(D data);
    String onPrepareCacheKey(HashMap<String, Object> params);
  }

  private HashMap<String, Object> mCache = new HashMap<>();

  //是否启用缓存
  private boolean mEnableCache = true;

  /**
   * 请求数据（不缓存）
   * @param params
   * @param callback
   * @param handler
   * @param <D>
   * @return
   */
  public <D> Disposable requestDataNoCache(final HashMap<String, Object> params,
      final OnDataCallback<D> callback, final OnRequestNoCacheHandler<D> handler) {
    //从网络加载
    return innerRequestFromRemote(params, callback, handler, false, false, true);
  }

  /**
   * 请求数据（缓存）
   * @param params
   * @param callback
   * @param handler
   * @param <D>
   * @return
   */
  public <D> Disposable requestData(final HashMap<String, Object> params,
      final OnDataCallback<D> callback, final OnRequestHandler<D> handler) {
    //if(handler == null){
    //  throw new Exception("OnRequestHandler can't be null");
    //}

    if (mEnableCache) {
      //查找缓存是否存在
      D cacheData = getFromCache(getParamsKey(handler, params));
      if (cacheData != null) {
        //从缓存加载
        return requestFromCache(cacheData, params, callback, handler);
      }
    }

    //从网络加载
    return innerRequestFromRemote(params, callback, handler, true, false, true);
  }

  private <D> Disposable requestFromCache(D cacheData, final HashMap<String, Object> params,
      final OnDataCallback<D> callback, final OnRequestHandler<D> handler) {

    return Flowable.just(cacheData).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnCancel(new Action() {
          @Override public void run() throws Exception {
            if (callback != null) {
              callback.onError(new CancelException("request canceled"));
            }
          }
        })
        .subscribe(new Consumer<D>() {
          @Override public void accept(@NonNull D bean) throws Exception {
            LogUtil.i("bean:" + bean + ", key:" + getParamsKey(handler, params));
            if (callback != null) {
              //通知加载成功
              notifySuccess(callback, bean, params);

              //加载下一页数据
              HashMap<String, Object> nextParams = handler.onPrepareNextParams(bean);
              if(nextParams != null){
                innerRequestFromRemote(nextParams, callback, handler, false, true, false);
              }
            }
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(@NonNull Throwable throwable) throws Exception {
            LogUtil.i("bean:" + throwable + ", key:" + getParamsKey(handler, params));
            if (callback != null) {
              callback.onError(throwable);
            }
          }
        });
  }

  /**
   * @param params 请求参数
   * @param loadNext 是否加载下一页
   * @param save2Cache 是否保存到缓存
   * @param notifyUpdate 是否通知更新
   */
  private <D> Disposable innerRequestFromRemote(final HashMap<String, Object> params,
      final OnDataCallback<D> callback, final OnRequestNoCacheHandler<D> handler, final boolean loadNext,
      final boolean save2Cache, final boolean notifyUpdate) {

    return Flowable.just("").subscribeOn(Schedulers.io())
        .flatMap(new Function<String, Publisher<D>>() {
          @Override public Publisher<D> apply(@NonNull String s) throws Exception {

            if (handler != null){
              return handler.onRequest(params);
            }

            return Flowable.just(null);
          }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .doOnCancel(new Action() {
          @Override public void run() throws Exception {
            if (callback != null) {
              callback.onError(new CancelException("request canceled"));
            }
          }
        })
        .subscribe(new Consumer<D>() {
          @Override public void accept(@NonNull D bean) throws Exception {
            LogUtil.i("bean:" + bean + ", key:" + params);

            if (notifyUpdate) {
              //通知加载成功
              notifySuccess(callback, bean, params);
            }

            if (mEnableCache) {
              //处理是否保存到缓存
              if (save2Cache) {
                OnRequestHandler cacheHandler = (OnRequestHandler) handler;
                String key = cacheHandler.onPrepareCacheKey(params);
                if (TextUtils.isEmpty(key)){
                  key = getParamsKey(cacheHandler, params);
                }
                addToCache(key, bean);
              }

              //处理是否加载下一页数据
              if (loadNext) {
                OnRequestHandler cacheHandler = (OnRequestHandler) handler;
                HashMap<String, Object> nextParams = cacheHandler.onPrepareNextParams(bean);
                if(nextParams != null){
                  innerRequestFromRemote(nextParams, callback, handler, false, true, false);
                }
              }
            }
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(@NonNull Throwable throwable) throws Exception {
            LogUtil.i("bean:" + throwable + ", key:" + params);
            if (callback != null) {
              callback.onError(throwable);
            }
          }
        });
  }

  private <D> void addToCache(String key, D bean) {
    LogUtil.i("bean:" + bean + ", " + key);
    mCache.put(key, bean);
  }

  private <D> D getFromCache(String key) {
    D bean = (D) mCache.remove(key);
    LogUtil.i("bean:" + bean + ", key:" + key);
    return bean;
  }

  private <D> void notifySuccess(OnDataCallback<D> callback, D bean, HashMap<String, Object> params) {
    LogUtil.i("bean:" + bean + ", key:" + params + ", " + callback);
    if (callback != null) {
      callback.onSuccess(bean);
    }
  }

  private <D> String getParamsKey(OnRequestHandler<D> handler, HashMap<String, Object> params) {
    String key = handler.onPrepareCacheKey(params);
    if (TextUtils.isEmpty(key)){
      key = "";
      for (HashMap.Entry<String, Object> item : params.entrySet()) {
        key += item.getKey() + "_" + item.getValue() + "_";
      }
    }
    return key;
  }

}
