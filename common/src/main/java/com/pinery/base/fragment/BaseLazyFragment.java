package com.pinery.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinery.base.mvp.IPresenter;
import com.pinery.base.util.LogUtil;

/**
 * 延迟加载数据Fragment
 */
public abstract class BaseLazyFragment<T extends IPresenter> extends BaseFragment<T> {

  /**
   * Fragment当前状态是否可见
   */
  protected boolean isVisible;
  /**
   * 是否已经在生命周期内加载过了
   */
  protected boolean isLoadedInLifecycle;
  /**
   * fragment是否已经初始化
   */
  protected boolean isFragmentCreated;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    isFragmentCreated = true;
  }

  @Override public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);

    if (getUserVisibleHint()) {
      isVisible = true;
      onVisible();
    } else {
      isVisible = false;
      onInvisible();
    }
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    if (isVisible) {
      lazyLoad();
    }
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    isFragmentCreated = true;

    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();

    isFragmentCreated = false;
    isLoadedInLifecycle = false;
  }

  /**
   * 可见
   */
  protected void onVisible() {
    if (!isFragmentCreated || isLoadedInLifecycle) {
      return;
    }

    lazyLoad();
  }

  /**
   * 不可见
   */
  protected void onInvisible() {

  }

  private void lazyLoad() {
    onLazyLoad();

    isLoadedInLifecycle = true;
  }

  /**
   * 延迟加载
   * 子类必须重写此方法
   */
  protected abstract void onLazyLoad();
}