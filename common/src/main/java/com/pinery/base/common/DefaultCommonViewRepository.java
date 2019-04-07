package com.pinery.base.common;

import android.content.Context;
import com.pinery.base.common.loading.ILoadingView;
import com.pinery.base.common.toast.IToastView;
import com.pinery.base.widget.LoadingView;
import com.pinery.base.widget.ToastView;

/**
 * Created by gujian on 2018-08-11.
 */

public class DefaultCommonViewRepository extends CommonViewRepository {

  public DefaultCommonViewRepository(Context context){
    super(context);
  }

  @Override public Class<? extends ILoadingView> provideLoadingView() {
    return LoadingView.class;
  }

  @Override public Class<? extends IToastView> provideToastView() {
    return ToastView.class;
  }

}
