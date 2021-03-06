package com.pinery.base.mvp;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;

/**
 * 便于管理所有Presenter的Disposable
 */
public abstract class BaseRxJavaPresenter<T extends IView> implements IPresenter<T> {

  protected T mView;
  protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

  @Override public void attachView(T view) {
    mView = view;
  }

  @Override public void detachView() {
    this.mView = null;
    dispose();
  }

  public void addDisposable(Disposable disposable) {
    if (mCompositeDisposable == null) {
      mCompositeDisposable = new CompositeDisposable();
    }
    if(disposable != null){
      mCompositeDisposable.add(disposable);
    }
  }

  public void dispose() {
    if (mCompositeDisposable != null) {
      if (!mCompositeDisposable.isDisposed()) {
        mCompositeDisposable.dispose();
      }
      mCompositeDisposable.clear();
      mCompositeDisposable = null;
    }
  }

}
