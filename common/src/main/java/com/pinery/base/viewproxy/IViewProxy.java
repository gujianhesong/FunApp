package com.pinery.base.viewproxy;

import android.view.View;

/**
 * Created by gujian on 2018-08-25.
 */

public interface IViewProxy {

  View onCreateView();

  void onDestroyView();

  int getLayoutId();

  View getView();

  void requestData();
}
