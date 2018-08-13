package com.pinery.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-11.
 */

public abstract class BaseActivity<T extends IPresenter> extends RxAppCompatActivity
    implements IView {

  protected static final int LAYOUT_ID_NULL = 0;

  @Inject protected T mPresenter;

  private CommonViewRepository mCommonViewRepository;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    int layoutResId = getLayoutResId();
    if (layoutResId != LAYOUT_ID_NULL) {
      setContentView(layoutResId);
    }

    initInjector();

    if (mPresenter != null) {
      mPresenter.attachView(this);
    }

    initViews();

    initData();

    if (mPresenter != null) {
      mPresenter.onStart();
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    if (mPresenter != null) {
      mPresenter.detachView();
      mPresenter = null;
    }
  }

  @Override public void showToast(String message) {
    showShortToast(message);
  }

  @Override public void showErrorMessage(String message) {
    showShortToast(message);
  }

  @Override public void showLoadingDialog(boolean cancelable) {
    if (!isFinishing() && getCommonViewRepository() != null) {
      getCommonViewRepository().showLoading(cancelable);
    }
  }

  @Override public void hideLoadingDialog() {
    if (!isFinishing()
        && getCommonViewRepository() != null
        && getCommonViewRepository().isShowing()) {
      getCommonViewRepository().hideLoading();
    }
  }

  public void gotoPage(Class<? extends Activity> clazz) {
    gotoPage(clazz, null);
  }

  public void gotoPage(Class<? extends Activity> clazz, Bundle bundle) {
    Intent intent = new Intent(this, clazz);
    if (bundle != null) {
      intent.putExtras(bundle);
    }
    startActivity(intent);
  }

  private CommonViewRepository getCommonViewRepository() {
    if (mCommonViewRepository == null) {
      mCommonViewRepository = provideCommonViewRepository();
    }
    return mCommonViewRepository;
  }

  private void showShortToast(CharSequence text) {
    if (getCommonViewRepository() != null && !isFinishing()) {
      getCommonViewRepository().showShortToast(text);
    }
  }

  protected abstract void initInjector();

  protected abstract int getLayoutResId();

  protected abstract void initViews();

  protected abstract void initData();

  protected abstract CommonViewRepository provideCommonViewRepository();
}
