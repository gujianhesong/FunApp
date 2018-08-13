package com.pinery.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinery.base.activity.BaseActivity;
import com.pinery.base.mvp.IPresenter;
import com.pinery.base.mvp.IView;
import com.trello.rxlifecycle2.components.support.RxFragment;
import javax.inject.Inject;

public abstract class BaseFragment<T extends IPresenter> extends RxFragment implements IView {

  protected View rootView;

  @Inject protected T mPresenter;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    if (rootView == null) {
      rootView = inflater.inflate(getLayoutId(), container, false);
    }

    ViewGroup parent = (ViewGroup) rootView.getParent();
    if (parent != null) {
      parent.removeView(rootView);
    }

    initInjector();

    if (mPresenter != null) {
      mPresenter.attachView(this);
    }

    initViews(rootView, savedInstanceState);

    initData();

    if (mPresenter != null) {
      mPresenter.onStart();
    }

    return rootView;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();

    if (mPresenter != null) {
      mPresenter.detachView();
      mPresenter = null;
    }
  }

  public BaseActivity getBaseActivity() {
    if (getActivity() instanceof BaseActivity) {
      return (BaseActivity) getActivity();
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

  protected abstract void initInjector();

  protected abstract int getLayoutId();

  protected abstract void initViews(View view, Bundle savedInstanceState);

  protected abstract void initData();

}