package com.pinery.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinery.base.mvp.IPresenter;
import javax.inject.Inject;

public abstract class BaseFragment<T extends IPresenter> extends BFragment {

  protected View rootView;

  @Inject protected T mPresenter;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    if (this.getClass().getName().contains("HomeFragment")){
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
    }else{

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

  protected abstract void initInjector();

  protected abstract int getLayoutId();

  protected abstract void initViews(View view, Bundle savedInstanceState);

  protected abstract void initData();

}