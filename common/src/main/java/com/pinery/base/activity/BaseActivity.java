package com.pinery.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.pinery.base.mvp.IPresenter;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-11.
 */

public abstract class BaseActivity<T extends IPresenter> extends BActivity {

  protected static final int LAYOUT_ID_NULL = 0;

  @Inject protected T mPresenter;

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

  protected abstract void initInjector();

  protected abstract int getLayoutResId();

  protected abstract void initViews();

  protected abstract void initData();
}
