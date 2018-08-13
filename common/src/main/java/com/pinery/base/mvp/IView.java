package com.pinery.base.mvp;

/**
 * View基类
 */
public interface IView {

  /**
   * 显示错误信息
   */
  void showErrorMessage(String message);

  /**
   * 显示错误信息
   */
  void showToast(String message);

  /**
   * 显示加载弹框
   */
  void showLoadingDialog(boolean cancelable);

  /**
   * 隐藏加载弹框
   */
  void hideLoadingDialog();

}