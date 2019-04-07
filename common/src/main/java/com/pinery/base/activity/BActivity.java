package com.pinery.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.pinery.base.common.CommonViewRepository;
import com.pinery.base.common.DefaultCommonViewRepository;
import com.pinery.base.mvp.IView;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by gujian on 2018-08-11.
 */

public abstract class BActivity extends RxAppCompatActivity implements IView {

  private CommonViewRepository mCommonViewRepository;

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

  protected CommonViewRepository provideCommonViewRepository() {
    return new DefaultCommonViewRepository(this);
  }
}
