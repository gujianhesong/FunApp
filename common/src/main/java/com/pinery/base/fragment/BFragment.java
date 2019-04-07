package com.pinery.base.fragment;

import com.pinery.base.activity.BActivity;
import com.pinery.base.mvp.IView;
import com.trello.rxlifecycle2.components.support.RxFragment;

public abstract class BFragment extends RxFragment implements IView {

  public BActivity getBaseActivity() {
    if (getActivity() instanceof BActivity) {
      return (BActivity) getActivity();
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

}