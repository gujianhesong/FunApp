package com.pinery.base.viewproxy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import javax.inject.Inject;

/**
 * Created by gujian on 2018-08-25.
 */

public abstract class BaseViewProxy<T extends IPresenter> implements IViewProxy, IView {

  @Inject protected T mPresenter;

  protected Context mContext;
  protected View mView;

  public BaseViewProxy(Context context){
    mContext = context;

    mView = LayoutInflater.from(mContext).inflate(getLayoutId(), null);

    initInjector();
  }

  @Override public View onCreateView() {
    if (mPresenter != null) {
      mPresenter.attachView(this);
    }

    initView(mView);

    initData();

    if (mPresenter != null) {
      mPresenter.onStart();
    }

    return mView;
  }

  @Override public void onDestroyView() {
    if (mPresenter != null) {
      mPresenter.detachView();
    }
  }

  @Override public View getView() {
    return mView;
  }

  @Override public void requestData() {

  }

  private BaseActivity getBaseActivity() {
    if (mContext instanceof BaseActivity) {
      return (BaseActivity) mContext;
    }
    return null;
  }

  @Override public void showToast(String message) {
    if (getBaseActivity() != null) {
      getBaseActivity().showToast(message);
    }
  }

  @Override public void showErrorMessage(String message) {
    if (getBaseActivity() != null) {
      getBaseActivity().showErrorMessage(message);
    }
  }

  @Override public void showLoadingDialog(boolean cancelable) {
    if (getBaseActivity() != null) {
      getBaseActivity().showLoadingDialog(cancelable);
    }
  }

  @Override public void hideLoadingDialog() {
    if (getBaseActivity() != null) {
      getBaseActivity().hideLoadingDialog();
    }
  }

  protected abstract void initView(View view);

  protected abstract void initInjector();

  protected abstract void initData();
}
